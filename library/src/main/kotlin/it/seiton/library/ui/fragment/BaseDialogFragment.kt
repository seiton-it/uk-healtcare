package it.seiton.library.ui.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by lukasw44 on 20/10/2016.
 */
abstract class BaseDialogFragment : CoreDialogFragment() {


    @LayoutRes
    abstract fun layoutResId(): Int

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId(), container, false)
    }

    fun fragmentTag(): String = javaClass.name

}