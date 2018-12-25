package com.zy.wanandroid.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


//@Entity(tableName = "student_table")
@Entity
data class Student(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)