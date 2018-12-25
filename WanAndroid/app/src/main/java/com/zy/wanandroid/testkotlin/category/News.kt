package com.zy.wanandroid.testkotlin.category


abstract class News {

    var origin = "reporter"

    abstract var content: String

    abstract fun newslength(): Int

}

class SchoolNews : News() {

    override var content: String = ""

    override fun newslength(): Int = content.length

}