package com.padc.batch9.assignment9.util

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager

class Utils {
    companion object {
        fun setStatusBarColor(context: Activity, color: Int) {
            if (Build.VERSION.SDK_INT >= 21) {
                val window = context.window
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                //View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                context.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = context.resources.getColor(color)
            }
        }
    }
}