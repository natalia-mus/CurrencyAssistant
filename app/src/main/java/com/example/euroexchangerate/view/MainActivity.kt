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
import com.example.euroexchangerate.Constants
import com.example.euroexchangerate.R
import com.example.euroexchangerate.adapter.RatesAdapter
import com.example.euroexchangerate.adapter.SingleDayAdapter
import com.example.euroexchangerate.data.RateDetails
import com.example.euroexchangerate.data.SingleDay
import com.example.euroexchangerate.viewmodel.MainActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), RatesAdapter.OnItemClickAction {

    lateinit var viewModel: MainActivityViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: SingleDayAdapter
    lateinit var progressBar: ProgressBar
    lateinit var navigation: BottomNavigationView
    private var _todayAlreadyFetched = false
    private var _scrollPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        recyclerView = findViewById(R.id.activity_main_recyclerView)
        progressBar = findViewById(R.id.activity_main_progressBar)
        navigation = findViewById(R.id.activity_main_bottomNavigation)

        setOnNavigationItemSelectedListener()
        setObservers()
        setListeners()
        renewVariables(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(Constants.TODAY_ALREADY_FETCHED, _todayAlreadyFetched)
        outState.putInt(Constants.SCROLL_POSITION, _scrollPosition)
    }

    private fun setOnNavigationItemSelectedListener() {
        navigation.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.rates -> rates()
                R.id.converter -> converter()
            }

            true
        }
    }

    private fun rates() {
        // TODO
    }

    private fun converter() {
         // TODO
    }

    private fun setObservers() {
        viewModel.selectedDateRates.observe(this) { updateView(it) }
        viewModel.loading.observe(this) { loading(it) }
        viewModel.success.observe(this) { responseStatusAction(it) }
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
        intent.putExtra(Constants.RATE_DETAILS, rateDetails)
        startActivity(intent)
    }

}