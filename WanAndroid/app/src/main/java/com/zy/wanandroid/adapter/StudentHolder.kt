package com.zy.wanandroid.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zy.wanandroid.R
import com.zy.wanandroid.model.Student
import kotlinx.android.synthetic.main.student_item.view.*


class StudentHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
) {

    var student: Student? = null

    fun bindTo(student: Student?) {
        this.student = student
        itemView.name.text = student!!.name
    }


}