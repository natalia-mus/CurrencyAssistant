package com.example.euroexchangerate.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.euroexchangerate.R
import com.example.euroexchangerate.adapter.RatesAdapter
import com.example.euroexchangerate.adapter.SingleDayAdapter
import com.example.euroexchangerate.data.RateDetails
import com.example.euroexchangerate.data.SingleDay
import com.example.euroexchangerate.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), RatesAdapter.OnItemClickAction {

    lateinit var viewModel: MainActivityViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: SingleDayAdapter
    lateinit var progressBar: ProgressBar
    private var todayAlreadyFetched = false
    private var scrollPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        recyclerView = findViewById(R.id.activity_main_recyclerView)
        progressBar = findViewById(R.id.activity_main_progressBar)

        setObservers()
        setListeners()
        renewVariables(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("todayAlreadyFetched", todayAlreadyFetched)
        outState.putInt("scrollPosition", scrollPosition)
    }

    private fun setObservers() {
        viewModel.selectedDateRates.observe(this, { updateView(it) })
        viewModel.loading.observe(this, { loading(it) })
        viewModel.success.observe(this, { responseStatusAction(it) })
    }

    private fun setListeners() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val bottom = recyclerView.getChildAt(0).height - recyclerView.height
                scrollPosition += dy

                if (scrollPosition >= bottom) {
                    viewModel.getNewData()
                    scrollPosition = 0
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }

    private fun renewVariables(savedInstanceState: Bundle?) {
        val _todayAlreadyFetched = savedInstanceState?.getBoolean("todayAlreadyFetched")

        if (_todayAlreadyFetched != null) {
            todayAlreadyFetched = _todayAlreadyFetched
        }

        if (!todayAlreadyFetched) {
            viewModel.getNewData()
            todayAlreadyFetched = true
        }

        val _scrollPosition = savedInstanceState?.getInt("scrollPosition")

        if (_scrollPosition != null) {
            scrollPosition = _scrollPosition
        }

    }

    private fun updateView(data: MutableList<SingleDay?>) {
        if (::adapter.isInitialized) {
            adapter.dataSetChanged(data)
        } else {
            layoutManager = LinearLayoutManager(this)
            adapter = SingleDayAdapter(data, this, this)
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
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show()
        }
    }

    override fun itemClicked(rateDetails: RateDetails) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("rateDetails", rateDetails)
        startActivity(intent)
    }

}