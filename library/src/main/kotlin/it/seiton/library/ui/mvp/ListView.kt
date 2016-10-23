package it.seiton.library.ui.mvp

/**
 * Created by lukasw44 on 23/10/2016.
 */
interface ListView : Mvp.View {

    fun showError(stringId: Int)

    fun showLoading()

    fun showEmpty()

    fun showList()
}