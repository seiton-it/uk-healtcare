package it.seiton.library.ui.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.seiton.library.ui.fragment.CoreFragment

/**
 * Created by lukasw44 on 17/10/2016.
 */
abstract class BaseFragment : CoreFragment() {

    @LayoutRes
    abstract fun layoutResId(): Int

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutResId(), container, false)
    }

    fun fragmentTag(): String = javaClass.name

}