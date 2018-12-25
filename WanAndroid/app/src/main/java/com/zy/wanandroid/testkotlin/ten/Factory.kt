package com.zy.wanandroid.testkotlin.ten

//适用于参数 ，简称 消费者
//interface Factory<in T> {
//    fun produce(produce: T)
//}
//适用于输出 ，简称 生产者
//interface Factory<out T> {
//    fun produce(): T
//}

interface Factory<T> {

    fun produce(): T

    fun produce(produce: T)

}

fun change(f: Factory<Any>) {
    val facotry_any: Factory<Any> = f
}
