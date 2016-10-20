package it.seiton.library.infrastructure.di

import android.content.Context

/**
 * Created by lukasw44 on 17/10/2016.
 */
object Injector {

    @Suppress("UNCHECKED_CAST")
    fun <C> obtain(context: Context, component: Class<C>): C = (context as HasComponent<C>).component()
}