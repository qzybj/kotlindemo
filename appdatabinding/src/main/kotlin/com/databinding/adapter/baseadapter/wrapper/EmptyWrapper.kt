package com.databinding.adapter.baseadapter.wrapper

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

import com.intime.mjpos.adapter.baseadapter.base.ViewHolder
import com.intime.mjpos.adapter.baseadapter.utils.WrapperUtils


/**
 * Created by zhy on 16/6/23.
 */
class EmptyWrapper<T>(private val mInnerAdapter: RecyclerView.Adapter<*>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mEmptyView: View? = null
    private var mEmptyLayoutId: Int = 0

    private val isEmpty: Boolean
        get() = (mEmptyView != null || mEmptyLayoutId != 0) && mInnerAdapter.itemCount == 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (isEmpty) {
            val holder: ViewHolder
            if (mEmptyView != null) {
                holder = ViewHolder.createViewHolder(parent.context, mEmptyView)
            } else {
                holder = ViewHolder.createViewHolder(parent.context, parent, mEmptyLayoutId)
            }
            return holder
        }
        return mInnerAdapter.onCreateViewHolder(parent, viewType)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        WrapperUtils.onAttachedToRecyclerView(mInnerAdapter, recyclerView, object : WrapperUtils.SpanSizeCallback() {
            fun getSpanSize(gridLayoutManager: GridLayoutManager, oldLookup: GridLayoutManager.SpanSizeLookup?, position: Int): Int {
                return if (isEmpty) {
                    gridLayoutManager.spanCount
                } else oldLookup?.getSpanSize(position) ?: 1
            }
        })


    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder?) {
        mInnerAdapter.onViewAttachedToWindow(holder)
        if (isEmpty) {
            WrapperUtils.setFullSpan(holder)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (isEmpty) {
            ITEM_TYPE_EMPTY
        } else mInnerAdapter.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isEmpty) {
            return
        }
        mInnerAdapter.onBindViewHolder(holder, position)
    }

    override fun getItemCount(): Int {
        return if (isEmpty) 1 else mInnerAdapter.itemCount
    }


    fun setEmptyView(emptyView: View) {
        mEmptyView = emptyView
    }

    fun setEmptyView(layoutId: Int) {
        mEmptyLayoutId = layoutId
    }

    companion object {
        val ITEM_TYPE_EMPTY = Integer.MAX_VALUE - 1
    }

}
