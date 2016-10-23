package it.seiton.library.ui.fragment

import android.content.Intent
import android.os.Bundle
import it.seiton.library.ui.mvp.CorePresenter
import it.seiton.library.ui.mvp.Mvp
import timber.log.Timber

/**
 * Created by lukasw44 on 22/10/2016.
 */
abstract class BaseMvpDialogFragment<in V : Mvp.View, P : CorePresenter<V>> : BaseDialogFragment(), Mvp.View {

    lateinit var presenter: P

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = onCreatePresenter()
        presenter.onCreate(arguments, savedInstanceState)
        onCreateFragment(savedInstanceState)
    }

    abstract fun onCreatePresenter(): P

    protected open fun onCreateFragment(savedInstanceState: Bundle?) {

    }

    override fun showDialog(dialog: BaseDialogFragment) {
        activity?.let { it ->
            dialog.show(it.supportFragmentManager, dialog.fragmentTag())
        }
    }

    override fun maybeStartActivity(intent: Intent) {

        Timber.i("maybe start activity : $intent")
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Timber.tag(this.javaClass.name).i(e, "Can not start external activity, for intent: $intent")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onTakeView(this as V)
        presenter.onActivityCreated()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        presenter.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDropView()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}