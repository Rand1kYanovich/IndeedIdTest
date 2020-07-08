package com.example.ideentyidtest.ui.list.savedphoto

import com.bumptech.glide.Glide
import com.example.ideentyidtest.R
import com.example.ideentyidtest.entity.core.feed.Photo
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import kotlinx.android.synthetic.main.rv_saved_photo_item.view.*

fun savedPhotoAdapterDelegate(onDeleteClick: (Photo, Int) -> Unit) =
    adapterDelegate<Photo, Photo>(R.layout.rv_saved_photo_item) {

        bind {
            with(itemView) {
                Glide.with(context)
                    .load(item.link)
                    .fitCenter()
                    .placeholder(R.color.gray)
                    .into(ivImage)

                ivDelete.setOnClickListener {
                    onDeleteClick(item, adapterPosition)
                }

            }

        }
    }