package com.databinding.adapter.baseadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

import com.intime.mjpos.adapter.baseadapter.base.ItemViewDelegate
import com.intime.mjpos.adapter.baseadapter.base.ItemViewDelegateManager
import com.intime.mjpos.adapter.baseadapter.base.ViewHolder

import java.util.ArrayList

/**
 * Created by zhy on 16/4/9.
 */
open class MultiItemTypeAdapter<T>(context: Context?, datas: List<T>?) : RecyclerView.Adapter<ViewHolder>() {
    protected var mContext: Context? = null
    var datas: List<T>
        protected set

    protected var mItemViewDelegateManager: ItemViewDelegateManager
    protected var mOnItemClickListener: OnItemClickListener? = null


    init {
        var datas = datas
        if (context != null) {
            mContext = context.applicationContext
        }
        if (datas == null) {
            datas = ArrayList()
        }
        this.datas = datas
        mItemViewDelegateManager = ItemViewDelegateManager()
    }

    /**
     * 刷新数据
     * @param mDatas
     */
    fun refreshData(mDatas: List<T>) {
        this.datas = mDatas
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (!useItemViewDelegateManager()) super.getItemViewType(position) else mItemViewDelegateManager.getItemViewType(datas[position], position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewDelegate = mItemViewDelegateManager.getItemViewDelegate(viewType)
        val layoutId = itemViewDelegate.getItemViewLayoutId()
        val holder = ViewHolder.createViewHolder(mContext, parent, layoutId)
        onViewHolderCreated(holder, holder.getConvertView())
        setListener(parent, holder, viewType)
        return holder
    }

    fun onViewHolderCreated(holder: ViewHolder, itemView: View) {

    }

    fun convert(holder: ViewHolder, t: T) {
        mItemViewDelegateManager.convert(holder, t, holder.getPosition())
    }

    protected fun isEnabled(viewType: Int): Boolean {
        return true
    }


    protected fun setListener(parent: ViewGroup, viewHolder: ViewHolder, viewType: Int) {
        if (!isEnabled(viewType)) return
        viewHolder.getConvertView().setOnClickListener(View.OnClickListener { v ->
            if (mOnItemClickListener != null) {
                val position = viewHolder.getPosition()
                mOnItemClickListener!!.onItemClick(v, viewHolder, position)
            }
        })

        viewHolder.getConvertView().setOnLongClickListener(View.OnLongClickListener { v ->
            if (mOnItemClickListener != null) {
                val position = viewHolder.getPosition()
                return@OnLongClickListener mOnItemClickListener!!.onItemLongClick(v, viewHolder, position)
            }
            false
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        convert(holder, datas[position])
    }

    override fun getItemCount(): Int {
        return if (mContext == null) {
            0
        } else datas.size
    }

    fun addItemViewDelegate(itemViewDelegate: ItemViewDelegate<T>): MultiItemTypeAdapter<*> {
        mItemViewDelegateManager.addDelegate(itemViewDelegate)
        return this
    }

    fun addItemViewDelegate(viewType: Int, itemViewDelegate: ItemViewDelegate<T>): MultiItemTypeAdapter<*> {
        mItemViewDelegateManager.addDelegate(viewType, itemViewDelegate)
        return this
    }

    protected fun useItemViewDelegateManager(): Boolean {
        return mItemViewDelegateManager.getItemViewDelegateCount() > 0
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, holder: RecyclerView.ViewHolder, position: Int)

        fun onItemLongClick(view: View, holder: RecyclerView.ViewHolder, position: Int): Boolean
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }
}
