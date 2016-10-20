package it.seiton.library.ui.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import rx.functions.Action1
import java.util.*

/**
 * Created by lukasw44 on 19/10/2016.
 */
abstract class RxRecyclerAdapter<E, VH : RecyclerView.ViewHolder>(items: ArrayList<E>, stableId: Boolean = true) : BaseRecyclerAdapter<E, VH>(items, stableId), Action1<List<E>> {

    constructor() : this(ArrayList())

    override fun call(items: List<E>) {
        addAll(items)
    }
}