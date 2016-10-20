package it.seiton.library.ui.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

/**
 * Created by lukasw44 on 19/10/2016.
 */
abstract class BaseRecyclerAdapter<E, VH : RecyclerView.ViewHolder>(items: ArrayList<E>, stableId: Boolean = true) : RecyclerView.Adapter<VH>() {

    val items: ArrayList<E>

    /**
     * Lock used to modify the content of [.mObjects]. Any write operation
     * performed on the array should be synchronized on this lock.
     */
    private val lock = Any()

    var notifyOnChange = true

    constructor(context: Context) : this(ArrayList())

    init {
        this.items = items
        //setHasStableIds(stableId)
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateViewHolder(LayoutInflater.from(parent.context), parent, viewType)
    }

    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): VH

    override fun getItemCount(): Int = items.size

    fun isEmpty(): Boolean = items.isEmpty()

    fun getItem(position: Int): E = items[position]

    fun getPosition(item: E) = items.indexOf(item)

    fun add(item: E) {
        var pos: Int = -1
        synchronized(lock) {
            pos = itemCount
            this.items.add(item)
        }
        if (notifyOnChange) notifyItemInserted(pos)
    }

    fun addAll(items: Collection<E>) {
        var pos: Int = -1
        synchronized(lock) {
            pos = itemCount
            this.items.addAll(items)
        }
        if (notifyOnChange) notifyItemRangeInserted(pos, items.size)
    }

    fun addAll(vararg items: E) {
        var start: Int = -1
        synchronized(lock) {
            start = itemCount
            Collections.addAll<E>(this.items, *items)
        }
        if (notifyOnChange) notifyItemRangeInserted(start, items.size)
    }

    fun insert(item: E, index: Int) {
        synchronized(lock) {
            items.add(index, item)
        }
        if (notifyOnChange) notifyItemInserted(index)
    }

    fun remove(item: E) {
        var pos: Int = -1
        synchronized(lock) {
            pos = getPosition(item)
            if (pos == -1) return
            this.items.removeAt(pos)
        }
        if (notifyOnChange) notifyItemRemoved(pos)
    }

    fun clear() {
        synchronized(lock) {
            this.items.clear()
        }
        if (notifyOnChange) notifyDataSetChanged()
    }

    fun sort(comparator: Comparator<in E>) {
        synchronized(lock) {
            Collections.sort<E>(this.items, comparator)
        }
        if (notifyOnChange) notifyDataSetChanged()
    }
}