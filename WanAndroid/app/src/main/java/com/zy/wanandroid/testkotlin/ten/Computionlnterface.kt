package com.zy.wanandroid.testkotlin.ten


interface Computionlnterface<T> {

    fun add(numl: T, num2: T)

    fun sub(numl: T, num2: T)

    fun mul(numl: T, num2: T)

    fun div(numl: T, num2: T)

}

class Compution<T> : Computionlnterface<T> {
    override fun add(numl: T, num2: T) {

    }

    override fun sub(numl: T, num2: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mul(numl: T, num2: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun div(numl: T, num2: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
