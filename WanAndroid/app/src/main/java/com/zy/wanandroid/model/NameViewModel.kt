package com.zy.wanandroid.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class NameViewModel : ViewModel() {

    var age: LiveData<Int>? = null
    var names: MutableLiveData<String>? = null



    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


}
