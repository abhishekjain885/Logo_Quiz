package com.example.quiz.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String, progressBar: ProgressBar? = null) =
    Picasso.get()
        .load(url)
        .placeholder(android.R.color.white)
        .into(this, object : Callback {

            override fun onError(e: java.lang.Exception?) {
                e?.printStackTrace()
            }

            override fun onSuccess() {
                progressBar?.visibility = View.GONE
            }
        })