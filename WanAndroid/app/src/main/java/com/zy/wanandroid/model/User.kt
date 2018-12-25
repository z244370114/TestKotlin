package com.zy.wanandroid.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ids") var id: Int?,
    var userName: String?,
    var age: Int?,
    var sex: String?,
    @Ignore var picture: String?
) {
    constructor() : this(0, "name", 10, "男", "10")
}