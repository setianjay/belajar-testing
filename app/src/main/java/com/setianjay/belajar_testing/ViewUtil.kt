package com.setianjay.belajar_testing

import android.view.View

object ViewUtil {

    fun View.show(isShowing: Boolean){
        this.visibility = if (isShowing) View.VISIBLE else View.GONE
    }
}