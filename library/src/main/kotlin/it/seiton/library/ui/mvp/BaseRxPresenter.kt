package it.seiton.library.ui.mvp

import rx.subscriptions.CompositeSubscription

/**
 * Created by lukasw44 on 22/10/2016.
 */
abstract class BaseRxPresenter<V : Mvp.View> : BasePresenter<V>() {

    lateinit var compositeSubscription: CompositeSubscription

    override fun onActivityCreated() {
        super.onActivityCreated()
        compositeSubscription = CompositeSubscription()
    }

    override fun onDropView() {
        super.onDropView()
        compositeSubscription.unsubscribe()
    }
}