package com.zy.wanandroid.net


interface DownloadListener {
    fun loading(i: Long) {
        println("javaClass = $i")
    }

    fun complete() {
        println("javaClass = 下载完成")

    }


}