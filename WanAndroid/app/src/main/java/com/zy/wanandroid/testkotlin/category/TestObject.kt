package com.zy.wanandroid.testkotlin.category


fun main(args: Array<String>) {

    val friend = Friend("zhou", true, "红色", 200)

}

class User(var name: String, var age: Int) {

    constructor(name: String, age: Int, type: String) : this(name, age) {


    }


}


