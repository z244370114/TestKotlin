package com.zy.wanandroid.testkotlin.ten

/**
 *<p/>
 * 作者：zhouyuan on  2018/12/5 10:54
 *<p/>
 * 邮箱：244370114@qq.com
 * <p/>
 *
 */
class Container(thing: Any) {
    val thing = thing

    fun printinformation() = println(" This  thing  is  $thing ")
}

class Containers<T>(thing: T) {
    val thing = thing

    fun printinformation() = println(" This  thing  is  $thing ")
}


class StringFactory : Factory<String> {
    override fun produce(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun produce(produce: String) {
        println("produce$produce")
    }
}

class IntFactory : Factory<Int> {
    override fun produce(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun produce(produce: Int) {

    }

}

class MyFactory<T> : Factory<T> {
    override fun produce(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun produce(produce: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


fun main(args: Array<String>) {

    val cO = Container(1)
    cO.printinformation()
    val cl = Container(" hi ")
    cl.printinformation()
    val c2 = Container(2.0)
    c2.printinformation()

    val c = Containers(1)
    c.printinformation()

}

fun one_int_container_say_hello(c: Container) {
    c.printinformation()
}

fun <T> one_int_container_say_hello(c: Containers<T>) {
    c.printinformation()
}