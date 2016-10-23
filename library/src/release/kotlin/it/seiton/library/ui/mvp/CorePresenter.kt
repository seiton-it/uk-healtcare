package it.seiton.library.ui.mvp

import android.os.Bundle
import it.seiton.library.ui.mvp.Mvp.Presenter
import timber.log.Timber

/**
 * Created by lukasw44 on 20/10/2016.
 */
abstract class CorePresenter<in V : Mvp.View> : Presenter {

    open fun onTakeView(v: V){
    }

    open fun onCreate(arguments: Bundle?, savedInstanceState: Bundle?) {
    }

    open fun onActivityCreated() {
    }

    open fun onResume(){
    }

    open fun onSaveInstanceState(outState: Bundle?){
    }

    open fun onViewStateRestored(savedInstanceState: Bundle?) {
    }

    open fun onPause() {
    }

    open fun onDropView() {
    }

    open fun onDestroy() {
    }
}