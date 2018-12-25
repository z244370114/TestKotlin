package com.zy.wanandroid.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val _data = MutableLiveData<String>()
    val mainDatas = MutableLiveData<List<MainViewModel>>()

    val data: LiveData<String> = _data

    val mainData: LiveData<List<MainViewModel>> = mainDatas

    val names: String = ""
    val age: Int = 0

    init {
        _data.value = "hello, world!"
        mainDatas.value = listOf(this)
    }


}
