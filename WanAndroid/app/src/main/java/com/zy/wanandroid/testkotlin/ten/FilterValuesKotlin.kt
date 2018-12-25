package com.zy.wanandroid.testkotlin.ten


fun main(args: Array<String>) {

    var a = listOf(1, 4, 2, 5, 1)
    println(filterValues(a, 4))

}

fun <T : Comparable<T>> filterValues(list: List<T>, up: T): List<T> {
    return list.filter { it <= up }
}


