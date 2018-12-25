package com.zy.wanandroid.model


class BaseDatas<T> {

    var datas: MutableList<T>? = null

    var curPage: Int = 0
    var offset: Int = 0
    var over: Boolean = false
    var pageCount: Int = 0
    var size: Int = 0
    var total: Int = 0


}
