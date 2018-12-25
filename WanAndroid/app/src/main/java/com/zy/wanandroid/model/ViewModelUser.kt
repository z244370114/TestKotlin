package com.zy.wanandroid.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel


class ViewModelUser(application: Application) : AndroidViewModel(application) {
//
//    var dao = StudentDb.get(application).userDao()
//
//    var users = LivePagedListBuilder(
//        dao.getAllUsers(), PagedList.Config.Builder()
//            .setPageSize(PAGE_SIZE)
//            .setPrefetchDistance(PAGE_SIZE)
//            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
//            .build()
//    ).build()

    companion object {
        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }
}
