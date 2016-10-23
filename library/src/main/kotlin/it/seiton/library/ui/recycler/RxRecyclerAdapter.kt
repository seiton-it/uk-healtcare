package it.seiton.library.ui.recycler

import android.support.v7.widget.RecyclerView
import it.seiton.library.domain.model.BaseEntity
import rx.functions.Action1
import java.util.*

/**
 * Created by lukasw44 on 19/10/2016.
 */
abstract class RxRecyclerAdapter<E : BaseEntity, VH : RecyclerView.ViewHolder>(items: ArrayList<E>, stableId: Boolean = true) : BaseRecyclerAdapter<E, VH>(items, stableId), Action1<List<E>> {

    constructor() : this(ArrayList())

    override fun call(items: List<E>) {
        addAll(items)
    }
}