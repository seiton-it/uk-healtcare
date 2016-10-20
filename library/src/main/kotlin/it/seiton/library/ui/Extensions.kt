package it.seiton.library.ui

import android.annotation.TargetApi
import android.os.Build
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by lukasw44 on 17/10/2016.
 */
fun Fragment.safeIsRtl(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && isRtl()
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
private fun Fragment.isRtl(): Boolean {
    val config = resources.configuration
    return config.layoutDirection == View.LAYOUT_DIRECTION_RTL
}