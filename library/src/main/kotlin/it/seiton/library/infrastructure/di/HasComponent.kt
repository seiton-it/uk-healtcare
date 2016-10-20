package it.seiton.library.infrastructure.di

/**
 * Created by lukasw44 on 17/10/2016.
 */
interface HasComponent<out C> {

    fun component(): C
}