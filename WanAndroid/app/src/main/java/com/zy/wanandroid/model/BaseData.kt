package com.zy.wanandroid.model


open class BaseData<T>(var data: BaseDatas<T>?, private var errorCode: Int?, private var errorMsg: String?) {
    constructor() : this(data = null, errorCode = 0, errorMsg = "")
}
