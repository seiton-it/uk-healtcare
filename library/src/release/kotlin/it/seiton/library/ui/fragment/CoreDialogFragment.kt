package it.seiton.library.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
abstract class CoreDialogFragment : DialogFragment() {

    final override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return onCreateDialogFragment(savedInstanceState)
    }

    abstract fun onCreateDialogFragment(savedInstanceState: Bundle?): Dialog

}