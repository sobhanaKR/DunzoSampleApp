package com.example.dunzoproject.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:setCdnImage")
    fun setCdnImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .error("https://farm66.staticflickr.com/65535/51309614840_c263787b6d_m.jpg")
            .override(100,100)
            .into(imageView)

    }