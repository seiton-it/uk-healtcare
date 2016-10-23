package it.seiton.library.infrastructure

import android.net.Uri
import timber.log.Timber

/**
 * Created by lukasw44 on 23/10/2016.
 */
fun Uri.parseSafe(uri: String): Uri {

    try{
        return Uri.parse(uri)
    }catch (e: Exception){
        Timber.e(e, "Uri exception while try parse : $uri")
        return Uri.EMPTY
    }

}