package it.seiton.common.ui

import com.squareup.leakcanary.RefWatcher

/**
 * Created by lukasw44 on 19/10/2016.
 */
interface HasRefWatcher {

    fun refWatcher(): RefWatcher
}