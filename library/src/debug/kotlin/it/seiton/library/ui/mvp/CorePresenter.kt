package it.seiton.library.ui.mvp

import android.os.Bundle
import it.seiton.library.ui.mvp.Mvp.Presenter
import timber.log.Timber

/**
 * Created by lukasw44 on 20/10/2016.
 */
abstract class CorePresenter<in V : Mvp.View> : Presenter {

    open fun onTakeView(v: V) {
        Timber.tag(this.javaClass.name).d("(P)::onTakeView(view), view : ${v.javaClass.name}")
    }

    open fun onCreate(arguments: Bundle?, savedInstanceState: Bundle?) {
        Timber.tag(this.javaClass.name).d("(P)::onCreate(savedInstanceState) , empty: ${savedInstanceState == null} ")
    }

    open fun onActivityCreated() {
        Timber.tag(this.javaClass.name).d("(P)::onActivityCreated()")
    }

    open fun onResume() {
        Timber.tag(this.javaClass.name).d("(P)::onResume()")
    }

    open fun onSaveInstanceState(outState: Bundle?) {
        Timber.tag(this.javaClass.name).d("(P)::onSaveInstanceState(outState), outState empty : ${outState == null}")
    }

    open fun onViewStateRestored(savedInstanceState: Bundle?) {
        Timber.tag(this.javaClass.name).d("(P)::onViewStateRestored(savedInstanceState), savedInstanceState empty : ${savedInstanceState == null}")
    }

    open fun onPause() {
        Timber.tag(this.javaClass.name).d("(P)::onPause()")
    }

    open fun onDropView() {
        Timber.tag(this.javaClass.name).d("(P)::onDropView()")

    }

    open fun onDestroy() {
        Timber.tag(this.javaClass.name).d("(P)::onDestroy()")
    }
}