package it.seiton.library.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by lukasw44 on 17/10/2016.
 */
open class CoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(this.javaClass.name, "(A)::onCreate(savedInstanceState, persistentState)")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(this.javaClass.name, "(A)::onCreate(savedInstanceState), empty: ${savedInstanceState == null}")
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        Log.d(this.javaClass.name, "(A)::onAttachFragment(fragment), fragment: ${fragment?.javaClass?.name}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(this.javaClass.name, "(A)::onResume()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(this.javaClass.name, "(A)::onStart()")
    }

    override fun onRestart() {
        super.onStart()
        Log.d(this.javaClass.name, "(A)::onRestart()")
    }

    override fun onPause() {
        super.onStart()
        Log.d(this.javaClass.name, "(A)::onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(this.javaClass.name, "(A)::onSaveInstanceState(outState), empty: ${outState == null})")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(this.javaClass.name, "(A)::onRestoreInstanceState(savedInstanceState), empty: ${savedInstanceState == null})")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(this.javaClass.name, "(A)::onDestroy()")

    }

}