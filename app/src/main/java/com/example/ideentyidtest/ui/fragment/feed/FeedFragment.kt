package com.example.ideentyidtest.ui.fragment.feed

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ideentyidtest.R
import com.example.ideentyidtest.ui.BaseFragment
import com.example.ideentyidtest.ui.list.feed.FeedRVAdapter
import com.example.ideentyidtest.viewmodel.feed.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_feed

    private val viewModel: FeedViewModel by viewModel()

    private val adapter: FeedRVAdapter by lazy {
        FeedRVAdapter {
            viewModel.onHearBtnClick(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rvFeed.layoutManager = layoutManager
        rvFeed.adapter = adapter

        viewModel.feedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}