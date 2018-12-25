package com.zy.wanandroid.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.zy.wanandroid.room.StudentDb


class StudentViewModel(application: Application) : AndroidViewModel(application) {

    val dao = StudentDb.get(application).studentDao()

    val allStudents = LivePagedListBuilder(dao.getAllStudent(), PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
            .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
            .build()).build()

    companion object {
        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }

}
