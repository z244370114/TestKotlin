//package com.zy.wanandroid.room
//
//import android.arch.persistence.room.Room
//import android.arch.persistence.room.RoomDatabase
//import android.content.Context
//import com.zy.wanandroid.dao.UserDao
//
//
////@Database(entities = [User::class], version = 1)
//abstract class UserRoomDatabase : RoomDatabase() {
//
//    abstract fun userDao(): UserDao
//
//    @Volatile
//    private var INSTANCE: UserRoomDatabase? = null
//
//    fun getDatabase(context: Context): UserRoomDatabase? {
//        if (INSTANCE == null) {
//            synchronized(UserRoomDatabase::class.java) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        UserRoomDatabase::class.java, "word_database"
//                    )
//                        .build()
//                }
//            }
//        }
//        return INSTANCE
//    }
//
//}
//
