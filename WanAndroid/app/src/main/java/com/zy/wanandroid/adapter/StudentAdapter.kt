package com.zy.wanandroid.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.zy.wanandroid.model.Student


class StudentAdapter : PagedListAdapter<Student, StudentHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StudentHolder {
        return StudentHolder(parent)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        val item = getItem(position)!!
        holder.bindTo(item)
//        holder.itemView.name.text = item.name
    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<Student>() {

            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean =
                    oldItem == newItem

        }

    }

}
