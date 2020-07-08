package com.example.ideentyidtest.ui.list.feed

import androidx.recyclerview.widget.DiffUtil
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.example.ideentyidtest.entity.core.feed.Photo
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.paging.PagedListDelegationAdapter

fun ImageItem.isSame(image: ImageItem) = this.id == image.id

class FeedRVAdapter(onHeartClick: (ImageItem) -> Unit) : PagedListDelegationAdapter<ImageItem>(
    AdapterDelegatesManager<List<ImageItem>>().addDelegate(
        feedAdapterDelegate {
            onHeartClick(it)
        }
    ),
    object : DiffUtil.ItemCallback<ImageItem>() {
        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem) =
            oldItem.isSame(newItem)

        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem) =
            oldItem.isSame(newItem)

    }
)