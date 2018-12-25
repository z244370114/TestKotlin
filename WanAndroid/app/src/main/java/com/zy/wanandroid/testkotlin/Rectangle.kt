package com.zy.wanandroid.testkotlin

import java.util.*


/**
 *<p/>
 * 作者：zhouyuan on  2018/12/3 15:11
 *<p/>
 * 邮箱：244370114@qq.com
 * <p/>
 *
 */
class Rectangle(var hegiht: Int, var width: Int) {

    val isSquare: Boolean
        get() {
            return hegiht == width
        }
}

fun createRectangle(): Rectangle {
    val random = Random()
    val rectangle = Rectangle(random.nextInt(), random.nextInt())
    println("rectangle.hegiht = ${rectangle.hegiht}")
    println("rectangle.width = ${rectangle.width}")
    return rectangle
}
