package com.ethan.bridj.feature.events

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ethan.bridj.R
import com.ethan.bridj.databinding.ActivityEventsBinding
import com.ethan.bridj.feature.events.adapter.EventAdapter
import com.ethan.bridj.feature.events.model.EventsViewState
import com.techiness.progressdialoglibrary.ProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsActivity : AppCompatActivity() {

    private val viewModel by viewModels<EventsViewModel>()

    private lateinit var viewBinding: ActivityEventsBinding

    private val progressDialog: ProgressDialog by lazy {
        ProgressDialog(this)
    }

    private val seatAvailableAdapter: EventAdapter by lazy {
        EventAdapter()
    }

    private val playAdapter: EventAdapter by lazy {
        EventAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityEventsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
        setupObservers()

        viewModel.getEvents()
    }

    private fun setupObservers() {
        viewModel.detailViewState.observe(this, {
            when (it) {
                is EventsViewState.Error -> {
                    progressDialog.dismiss()
                    Toast.makeText(this, it.throwable?.message, Toast.LENGTH_SHORT)
                        .show()
                }
                is EventsViewState.GetEventsSucceed -> {
                    progressDialog.dismiss()
                    seatAvailableAdapter.submitList(it.seatAvailableEvents)
                    playAdapter.submitList(it.playEvents)
                }
                EventsViewState.Loading -> {
                    progressDialog.show()
                }
            }
        })
    }

    private fun initViews() {
        with(viewBinding.rvSeatAvailableEvents) {
            adapter = seatAvailableAdapter
            isNestedScrollingEnabled = false
        }
        with(viewBinding.rvPlayEvents) {
            adapter = playAdapter
            isNestedScrollingEnabled = false
        }
        progressDialog.setMessage(getString(R.string.loading))
        progressDialog.setCancelable(true)
    }
}