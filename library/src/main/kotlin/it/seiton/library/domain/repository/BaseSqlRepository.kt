package it.seiton.library.domain.repository

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.squareup.sqlbrite.BriteDatabase
import it.seiton.common.infrastructure.datasource.inTransaction
import it.seiton.library.domain.model.BaseEntity
import it.seiton.library.domain.model.EntityMapper
import it.seiton.library.infrastructure.sql.Sort
import rx.Observable
import timber.log.Timber
import java.util.*

/**
 * Created by lukasw44 on 18/10/2016.
 */
open class BaseSqlRepository<E : BaseEntity, out M : EntityMapper<*, E>>(val database: BriteDatabase, val mapper: M, val tableName: String, val defaultSort: Sort = BaseSqlRepository.DEFAULT_SORT) : BaseRepository<E> {

    val selectAll = "SELECT * FROM $tableName ORDER BY "
    val selectById = "SELECT * FROM $tableName WHERE id = ?"

    override fun findAll(): Observable<List<E>> {
        return findAll(defaultSort)
    }

    override fun findAll(sort: Sort): Observable<List<E>> {
        return database.createQuery(tableName, ensureOrder(selectAll, sort))
                .map { query ->
                    val cursor: Cursor? = query.run()
                    if (cursor != null) {
                        val result = ArrayList<E>();
                        while (cursor.moveToNext()) {
                            val entity: E = mapper.mapToEntity(cursor)
                            result.add(entity)
                        }
                        result.toList()
                    } else {
                        emptyList<E>()
                    }
                }
    }

    override fun findById(id: Int): Observable<E?> {
        return database.createQuery(tableName, selectById, id.toString())
                .map { query ->
                    val cursor: Cursor? = query.run()
                    if (cursor != null && cursor.moveToNext()) {
                        mapper.mapToEntity(cursor)
                    }else{
                        null
                    }
                }
    }

    override fun saveOrUpdate(item: E) {
        database.inTransaction {
            insertOrUpdate(item)
        }
    }

    override fun saveOrUpdate(items: Iterable<E>) {
        database.inTransaction {
            var i = 0
            for (entity in items) {
                i++
                insertOrUpdate(entity)
            }
            Timber.tag(TAG).d("Inserted $i entities rows")
        }
    }

    override fun delete(item: E) {
        delete(item.id)
    }

    override fun delete(id: Int) {
        database.delete(tableName, "id = ?", id.toString())
    }

    private fun insertOrUpdate(entity: E) {
        database.insert(
                tableName,
                mapper.mapToContentValues(entity),
                SQLiteDatabase.CONFLICT_REPLACE
        )
    }

    private fun ensureOrder(sql: String, sort: Sort): String {
        return sql + sort.getOrdersBy()
    }

    companion object {
        const val TAG: String = "Repository"
        val DEFAULT_SORT = Sort(Sort.Order("id"))
    }
}