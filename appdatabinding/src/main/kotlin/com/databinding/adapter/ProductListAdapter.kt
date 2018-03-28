package com.databinding.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by zyb
 *
 * @date 2018/3/28
 * @description
 */
class ProductListAdapter(val items : List<String>) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}