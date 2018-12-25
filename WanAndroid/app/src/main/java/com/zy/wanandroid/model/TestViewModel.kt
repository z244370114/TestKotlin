package com.zy.wanandroid.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

/**
 *<p/>
 * 作者：zhouyuan on  2018/11/27 17:57
 *<p/>
 * 邮箱：244370114@qq.com
 * <p/>
 *
 */
class TestViewModel : ViewModel() {

    var mCurrent: MutableLiveData<String>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

    var liveDataMap: LiveData<Int> = Transformations.map<String, Int>(mCurrent!!) {
        it.length
    }

    var liveDataSwitch: LiveData<String> = Transformations.switchMap<String, String>(mCurrent!!) { s ->
        MutableLiveData<String>().also {
            it.value = s.toLowerCase()
        }
    }

}