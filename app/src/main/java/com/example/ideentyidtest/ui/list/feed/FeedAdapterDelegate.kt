package com.example.ideentyidtest.ui.list.feed

import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.ideentyidtest.R
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import kotlinx.android.synthetic.main.rv_feed_item.view.*

private val set = ConstraintSet()

fun feedAdapterDelegate(onHeartClick: (ImageItem) -> Unit) =
    adapterDelegate<ImageItem, ImageItem>(R.layout.rv_feed_item) {


        bind {
            with(itemView) {
                Glide.with(context)
                    .load(item.link)
                    .fitCenter()
                    .placeholder(R.color.gray)
                    .into(ivImage)


                val ratio = String.format("%d:%d", item.width, item.height)
                set.clone(clItem)
                set.setDimensionRatio(ivImage.id, ratio)
                set.applyTo(clItem)

                ivLike.setColorFilter(
                    if (item.isLiked) ContextCompat.getColor(
                        context,
                        R.color.red
                    ) else ContextCompat.getColor(
                        context,
                        R.color.gray
                    )
                )

                ivLike.setOnClickListener {
                    if (!item.isLiked) {
                        item.isLiked = true
                        ivLike.setColorFilter(ContextCompat.getColor(context, R.color.red))
                        onHeartClick(item)
                    }
                }
            }
        }
    }