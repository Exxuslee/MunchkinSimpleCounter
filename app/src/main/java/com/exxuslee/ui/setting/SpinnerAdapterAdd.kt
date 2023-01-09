package com.exxuslee.ui.setting

import android.content.Context
import android.content.res.TypedArray
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.exxuslee.R
import com.exxuslee.core.SpinnerAdapter

class SpinnerAdapterAdd(
    ctx: Context,
    resource: Int,
    spinnerTextView: Int,
    private val contentArray: Array<String>,
    private val imageArray: TypedArray
) : SpinnerAdapter(ctx, resource, contentArray, spinnerTextView) {

    override fun getCustomView(position: Int, parent: ViewGroup?): View {
        val row = super.getCustomView(position, parent)
        val textView = row.findViewById<View>(R.id.spinnerTextView) as TextView
        textView.text = contentArray[position]
        val imageView = row.findViewById<View>(R.id.spinnerImageView) as ImageView
        imageView.setImageDrawable(imageArray.getDrawable(position))
        return row
    }
}