package com.zy.wanandroid.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.zy.wanandroid.model.User


@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Insert
    fun insert(listUser: List<User>)

//    @Query("DELETE FROM user_table")
//    fun deleteAll(user: User)

    @Query("SELECT * from User ORDER BY ids ASC")
    fun getAllUser(): LiveData<List<User>>

//    @Query("SELECT * from user_table ORDER BY ids ASC")
    @Query("SELECT * FROM User ORDER BY ids COLLATE NOCASE ASC")
    fun getAllUsers(): DataSource.Factory<Int, User>

}