package it.seiton.library.domain.model

import android.content.ContentValues
import android.database.Cursor

/**
 * Created by lukasw44 on 18/10/2016.
 */
interface EntityMapper<in JS, E : BaseEntity> {

    fun mapToEntity(json: JS): E

    fun mapToEntity(cursor: Cursor): E

    fun mapToContentValues(entity: E): ContentValues
}