package com.example.ideentyidtest.ui.fragment.savedphoto

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ideentyidtest.ui.fragment.BaseFragment
import com.example.ideentyidtest.R
import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.ui.list.savedphoto.savedPhotoAdapterDelegate
import com.example.ideentyidtest.viewmodel.savedphoto.SavedPhotoViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.fragment_saved_photo.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedPhotoFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_saved_photo

    private val viewModel: SavedPhotoViewModel by viewModel()
    private val adapter: ListDelegationAdapter<List<Photo>> by lazy {
        ListDelegationAdapter(
            savedPhotoAdapterDelegate { item, position ->
                viewModel.onDeleteBtnClick(item)
                val list = adapter.items.toMutableList()
                list.remove(item)
                adapter.items = list
                adapter.notifyItemRemoved(position)
                if (list.isEmpty()) {
                    tvEmptyText.isVisible = true
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSavedPhoto.layoutManager = LinearLayoutManager(requireContext())
        rvSavedPhoto.adapter = adapter


        viewModel.listSavedImages.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                tvEmptyText.isVisible = true
            } else {
                adapter.items = it
                adapter.notifyDataSetChanged()
            }
        })
    }

}