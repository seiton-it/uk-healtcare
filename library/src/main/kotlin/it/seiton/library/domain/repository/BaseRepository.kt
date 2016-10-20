package it.seiton.library.domain.repository

import it.seiton.library.domain.model.BaseEntity
import it.seiton.library.infrastructure.sql.Sort
import rx.Observable

/**
 * Created by lukasw44 on 18/10/2016.
 */
interface BaseRepository<E : BaseEntity> {

    fun findAll(): Observable<List<E>>

    fun findAll(sort: Sort): Observable<List<E>>

    fun findById(id: Int): Observable<E?>

    fun saveOrUpdate(item: E)

    fun saveOrUpdate(items: Iterable<E>)

    fun delete(item: E)

    fun delete(id: Int)
}