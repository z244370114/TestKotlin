package com.zy.wanandroid.testkotlin

import java.io.File


//fun 代表函数的定义，
fun main(args: Array<String>) {

    val arrlist = arrayListOf(1, 2, 34, 5, 4, 3)
    println(arrlist)
    val list = listOf("1", "32", "322112")
    println("list = $list")

    val file1 = File("/user/bin")
    val file2 = File("/user/bin")
    val sameRefer = file1 === file2
    println("sameRefer = $sameRefer")

    val a到z = "a".."z"

    for (i in (1..100).step(3)) {
//        println("i = ${i}")
    }

    println(checkNumber(10))

    val number = 3
    when (number) {
        in 1..5 -> println("($number)属于这个区间")
        is Int -> println("并且还是整型参数")
    }

    val courseName = "我们现在正在学习Kotlin"
    println(courseName.substring(3))
    println(courseName.last())
    println(courseName.count())
    println(courseName.first())
    println(courseName[4])
    println(courseName.elementAt(4))
    println(courseName.substring(3, courseName.length))
    println(courseName.replace("Kotlin", "java"))

    println(arrlist.contains(6))
    println(arrlist.filter { it > 1 }[3])

    arrayInt()

}

fun arrayInt() {
    val numbers = arrayOf(0, -999, 100, 33, -2, 3000)
    val numbers2 = arrayOf(0, -999, 100, 33, -2, 3000)
    println(numbers.sortedArray().joinToString())//按数字大小进行排列
    println(numbers.sortedArrayDescending().joinToString())//按数字大小进行倒序排列
    println(numbers.map { "数字$it" })//针对数组元素进行转换
    println(numbers.filter { it % 2 == 0 })//针对数组每个元素进行判断
    println(numbers.max())//获取最大值
    println(numbers.min())//获取最小值
    println(numbers.all { it > 0 }) //判断数组里的元素是否全部都大于零，返回 true 或 false
    println(numbers.any { it < 0 }) //与 all相对,只要数组当中有某个元素小于零，返回true或false
    println(numbers.none { it == 0 }) // 但数组所有的元素都不满足条件，返回true 否则 false
    println(numbers.sum()) //计算求和
    println(numbers.sumBy { 10_000 + it }) //增强求和
    println(numbers.average()) //求平均值
    println(numbers.plus(numbers2).joinToString())//将numbers2 数组 追加到 numbers 后面
    println((numbers2 + numbers).joinToString()) //合并两个数组
}

// 使用数组常用的一些API
fun arrlistTest() {

    val nollstations = arrayOf(
        "嘉定北", "徐家汇", "商翔", "桃浦新村", "徐家汇",
        "上海四站", "罗山路", "池士尼", "嘉定新城", "徐家汇", "桃浦新村"
    )
    println(nollstations.first())
    println(nollstations.component1())
    println(nollstations.component2())
    println(nollstations.component3())
    println(nollstations.component4())
    println(nollstations.component5())
    println(nollstations.last())
    println(nollstations.contains("池士尼"))
    println(nollstations.find { it.contains("徐") })
    println(nollstations.findLast { it.contains("嘉") })
    println(nollstations.joinToString())
    println(nollstations.reversed().joinToString())
    println(nollstations.joinToString { it + "站" })
    println(nollstations.sortedBy { s -> s.length })
    println(nollstations.sortedByDescending { s -> s.length })
    println(nollstations.maxBy { s -> s.length })
    println(nollstations.distinct())
    println(nollstations.distinctBy { s -> s.length })
    println(nollstations.reduce { s1, s2 -> "$s1,$s2" })
    println(nollstations.reduceRight { s1, s2 -> "$s2,$s1" })
    println(nollstations.fold("地铁1 1号线站点") { sl, s2 -> "$sl-$s2" })
    println(nollstations.foldRight("是地铁1 1号线的站点．") { sl, s2 -> "$sl-$s2" })
    println(nollstations.sliceArray(2..5).joinToString())
    println(nollstations.take(2))
    println(nollstations.takeLast(3))
    println(nollstations.drop(3))
    println(nollstations.dropLast(3))
    println(nollstations.map { it + "map" })//针对数组元素进行转换
    println(nollstations.filter { it.contains("桃") })//筛选器，针对每个元素进行匹配


}

fun checkNumber(a: Int) {
    when (a) {
        0 -> print("a = 0")
        1 -> print("a = 1")
        else -> print("a= $a")
    }
}

fun isKotlin(any: Any): Boolean {
    return when (any) {
        is String -> any.startsWith("Kotlin")
        else -> false
    }
}


