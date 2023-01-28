package com.example.euroexchangerate.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.Constants
import com.example.euroexchangerate.R
import com.example.euroexchangerate.adapter.RatesAdapter
import com.example.euroexchangerate.adapter.SingleDayAdapter
import com.example.euroexchangerate.data.RateDetails
import com.example.euroexchangerate.data.SingleDayRates
import com.example.euroexchangerate.viewmodel.RatesViewModel

class RatesFragment : Fragment(), RatesAdapter.OnItemClickAction {

    private lateinit var fragmentView: View
    private lateinit var viewModel: RatesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SingleDayAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var layoutManager: LinearLayoutManager
    private var _todayAlreadyFetched = false
    private var _scrollPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentView = inflater.inflate(R.layout.fragment_rates, container, false)
        viewModel = ViewModelProvider(this).get(RatesViewModel::class.java)
        initView()
        setObservers()
        setListeners()
        renewVariables(savedInstanceState)
        return fragmentView
    }

    override fun itemClicked(rateDetails: RateDetails) {
        val intent = Intent(requireContext(), DetailsActivity::class.java)
        intent.putExtra(Constants.RATE_DETAILS, rateDetails)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(Constants.TODAY_ALREADY_FETCHED, _todayAlreadyFetched)
        outState.putInt(Constants.SCROLL_POSITION, _scrollPosition)
    }

    private fun initView() {
        recyclerView = fragmentView.findViewById(R.id.fragment_rates_recyclerView)
        progressBar = fragmentView.findViewById(R.id.fragment_rates_progressBar)
    }

    private fun setObservers() {
        viewModel.selectedDateRates.observe(viewLifecycleOwner) { updateView(it) }
        viewModel.loading.observe(viewLifecycleOwner) { loading(it) }
        viewModel.success.observe(viewLifecycleOwner) { responseStatusAction(it) }
    }

    private fun setListeners() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val bottom = recyclerView.getChildAt(0).height - recyclerView.height
                _scrollPosition += dy

                if (_scrollPosition >= bottom) {
                    viewModel.getNewData()
                    _scrollPosition = 0
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }

    private fun renewVariables(savedInstanceState: Bundle?) {
        val todayAlreadyFetched = savedInstanceState?.getBoolean(Constants.TODAY_ALREADY_FETCHED)

        if (todayAlreadyFetched != null) {
            _todayAlreadyFetched = todayAlreadyFetched
        }

        if (!_todayAlreadyFetched) {
            viewModel.getNewData()
            _todayAlreadyFetched = true
        }

        val scrollPosition = savedInstanceState?.getInt(Constants.SCROLL_POSITION)

        if (scrollPosition != null) {
            _scrollPosition = scrollPosition
        }

    }

    private fun updateView(data: MutableList<SingleDayRates>) {
        if (::adapter.isInitialized) {
            adapter.dataSetChanged(data)
        } else {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = SingleDayAdapter(data, requireContext(), this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    private fun loading(loading: Boolean) {
        if (loading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.INVISIBLE
        }
    }

    private fun responseStatusAction(success: Boolean) {
        if (!success) {
            Toast.makeText(activity, getString(R.string.error), Toast.LENGTH_LONG).show()
        }
    }

}