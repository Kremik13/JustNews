package com.software.kremiks.justnews.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(context: Context, url: String?) {
    url?.let {
        Glide.with(context)
                .load(it)
                .into(this)
        this.visibility = View.VISIBLE
    }
}