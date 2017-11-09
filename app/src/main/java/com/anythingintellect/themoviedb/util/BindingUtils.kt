package com.anythingintellect.themoviedb.util

import android.databinding.BindingAdapter
import android.util.Log
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by ishan.dhingra on 07/11/17.
 */
@BindingAdapter("bind:imgName", "bind:imgSize")
fun bindImageUrl(simpleDraweeView: SimpleDraweeView, imgName: String, imgSize: String) {
    val imgUrl = "${Constant.IMG_BASE_URL}${imgSize}${imgName}"
    simpleDraweeView.setImageURI(imgUrl)
}

@BindingAdapter("bind:visible")
fun bindVisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}