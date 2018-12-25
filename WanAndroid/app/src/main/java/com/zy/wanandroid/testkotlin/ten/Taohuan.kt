package com.zy.wanandroid.testkotlin.ten

/**
 *<p/>
 * 作者：zhouyuan on  2018/12/5 11:37
 *<p/>
 * 邮箱：244370114@qq.com
 * <p/>
 *
 */
class Taohuan {

    val outcolor: String = "red"
    val size: Int = 20
    val shape: String = "circle"

    inner class jianpin {
        val incolor: String = "blue"
        val size: Int = 15
        val shape: String = "rect"

        fun getOutSize():Int{
            return this@Taohuan.size
        }

    }

}

fun main(args: Array<String>) {

    val taohuan = Taohuan()

    val jianpin = Taohuan().jianpin()

    val mycolor = jianpin.incolor


}


class Game {
    val shape_taohuan: String = "circle"
    val size_jiangpin: Int = 15
    val shape_jiangpin: String = "rect"
}