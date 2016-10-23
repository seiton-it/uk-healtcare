package it.seiton.library.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import it.seiton.common.ui.HasRefWatcher

/**
 * Created by lukasw44 on 17/10/2016.
 */
open class CoreFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(this.javaClass.name, "(F)::onAttach(context), empty: ${context == null}, contextClass: ${context?.javaClass?.name}")
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        Log.d(this.javaClass.name, "(F)::onAttach(activity), empty: ${context == null}, contextClass: ${activity?.javaClass?.name}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(this.javaClass.name, "(F)::onCreate(savedInstanceState), empty : ${savedInstanceState == null}")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(this.javaClass.name, "(F)::onViewCreated(view,savedInstanceState), empty: ${savedInstanceState == null}")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(this.javaClass.name, "(F)::onActivityCreated(savedInstanceState), empty: ${savedInstanceState == null}")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(this.javaClass.name, "(F)::onActivityResult(requestCode,resultCode,data), requestCode: $requestCode, resultCode: $resultCode,data: $data ")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(this.javaClass.name, "(F)::onSaveInstanceState(outState), empty: ${outState == null}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(this.javaClass.name, "(F)::onViewStateRestored(savedInstanceState), empty: ${savedInstanceState == null}")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(this.javaClass.name, "(F)::onDetach()")

    }

    override fun onPause() {
        super.onPause()
        Log.d(this.javaClass.name, "(F)::onPause()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(this.javaClass.name, "(F)::onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(this.javaClass.name, "(F)::onDestroy()")
        val refWatcher = (context.applicationContext as HasRefWatcher).refWatcher()
        refWatcher.watch(this)
    }


}