package com.zy.wanandroid.dao

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.zy.wanandroid.model.Student

@Dao
interface StudentDao {

    @Query("SELECT * FROM Student ORDER BY name COLLATE NOCASE ASC")
    fun getAllStudent(): DataSource.Factory<Int, Student>

    @Insert
    fun insert(map: List<Student>)

    @Insert
    fun insert(student: Student)

}