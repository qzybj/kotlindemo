package com.databinding.adapter.baseadapter

import android.content.Context
import android.view.LayoutInflater

import com.intime.mjpos.adapter.baseadapter.base.ItemViewDelegate
import com.intime.mjpos.adapter.baseadapter.base.ViewHolder

import java.util.ArrayList

/**
 * Created by zhy on 16/4/9.
 */
abstract class CommonAdapter<T>(protected var mContext: Context, protected var mLayoutId: Int, datas: List<T>?) : MultiItemTypeAdapter<T>(mContext, datas) {
    protected var mDatas: List<T>
    protected var mInflater: LayoutInflater

    init {
        var datas = datas
        mInflater = LayoutInflater.from(mContext)
        if (datas == null) {
            datas = ArrayList()
        }
        mDatas = datas

        addItemViewDelegate(object : ItemViewDelegate<T>() {
            val itemViewLayoutId: Int
                get() = layoutId

            fun isForViewType(item: T, position: Int): Boolean {
                return true
            }

            fun convert(holder: ViewHolder, t: T, position: Int) {
                this@CommonAdapter.convert(holder, t, position)
            }
        })
    }

    protected abstract fun convert(holder: ViewHolder, t: T, position: Int)


}
