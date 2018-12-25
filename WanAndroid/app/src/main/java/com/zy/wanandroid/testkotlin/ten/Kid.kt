package com.zy.wanandroid.testkotlin.ten


interface hands {

    fun grow()

}

class Kid(name: String, age: Int) {

    var name = name
    var age = age

    fun action() {
        println("kid can play \n ")
    }

    companion object hand : hands {

        var size = 1

        override fun grow() {
            println("实现了hands接口")
        }

        fun action() {
            println("hand can play \n ")
        }

    }


}

fun main(args: Array<String>) {

    Kid.action()
    Kid.grow()
    val kid = Kid("周远", 25)
    kid.action()

}