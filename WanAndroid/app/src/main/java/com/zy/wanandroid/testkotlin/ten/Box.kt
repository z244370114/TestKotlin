package com.zy.wanandroid.testkotlin.ten

/**
 *<p/>
 * 作者：zhouyuan on  2018/12/5 10:32
 *<p/>
 * 邮箱：244370114@qq.com
 * <p/>
 *
 */
class Box(size: Int, shape: String) {
    var size = size
    var shape = shape
}

fun main(args: Array<String>) {

    val firstbox = Box(20, "circle")
    var secondbox = Box(20, "rect")
    var thirdbox = Box(20, "circle")
    var fourthbox = firstbox
    println("盒子1和盒子2比较：${firstbox.equals(secondbox)}\n ${firstbox.hashCode()}")
    println("盒子1和盒子3比较：${firstbox.equals(thirdbox)}\n ${thirdbox.hashCode()}")
    println("盒子1和盒子4比较：${firstbox.equals(fourthbox)}\n ${fourthbox.hashCode()}")

}