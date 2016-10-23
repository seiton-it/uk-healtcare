package it.seiton.library.ui.mvp

/**
 * Created by lukasw44 on 20/10/2016.
 */
abstract class BasePresenter<V : Mvp.View> : CorePresenter<V>() {

    var view: V? = null

    override fun onTakeView(v: V) {
        super.onTakeView(v)
        view = v
    }

    override fun onDropView() {
        super.onDropView()
        view = null
    }

}