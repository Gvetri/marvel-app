package com.example.giuseppe.demoapp.ui.adapters

import android.graphics.Color
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.TextView

object BindingAdapter {

    @android.databinding.BindingAdapter(value = ["colorByValue"])
    fun setTextColor(textView: TextView, string: String) {
        textView.setTextColor(if (string.contains("-")) Color.RED else Color.GREEN)
    }

    @android.databinding.BindingAdapter(value = ["colorByValue"])
    fun setTextColor(textView: AppCompatTextView, string: String) {
        textView.setTextColor(if (string.contains("-")) Color.RED else Color.GREEN)
    }

    @android.databinding.BindingAdapter(value = ["visibleGone"])
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}
