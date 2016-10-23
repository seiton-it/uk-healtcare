package it.seiton.library.ui.mvp

import android.content.Intent
import it.seiton.library.ui.fragment.BaseDialogFragment

/**
 * Created by lukasw44 on 20/10/2016.
 */
interface Mvp {

    interface Model{

    }

    interface View{

        fun showDialog(dialog: BaseDialogFragment)

        fun maybeStartActivity(intent: Intent)
    }

    interface Presenter{


    }
}