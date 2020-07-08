package com.example.ideentyidtest.ui.list.feed

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.bumptech.glide.Glide
import com.example.ideentyidtest.R
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

private val set = ConstraintSet()

fun feedAdapterDelegate(onClick: (String) -> Unit) =
    adapterDelegate<ImageItem, ImageItem>(R.layout.rv_feed_item) {

        val clItem: ConstraintLayout = findViewById(R.id.clItem)
        val ivImage: ImageView = findViewById(R.id.ivImage)

        bind {
            Glide.with(context)
                .load(item.link)
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .into(ivImage)


            val ratio = String.format("%d:%d", item.width, item.height)
            set.clone(clItem)
            set.setDimensionRatio(ivImage.id, ratio)
            set.applyTo(clItem)

            itemView.setOnClickListener {
                onClick(item.id)
            }
        }
    }