package it.seiton.common.infrastructure.datasource

import com.squareup.sqlbrite.BriteDatabase
import timber.log.Timber

/**
 * Created by lukasw44 on 09/10/2016.
 */
inline fun BriteDatabase.inTransaction(func: BriteDatabase.() -> Unit) {
    val transations = newTransaction()
    try {
        func()
        transations.markSuccessful()
    } catch (e: Exception) {
        Timber.e(e, "Exception while end transaction")
    } finally {
        transations.end()
    }
}