package com.zy.wanandroid.testkotlin


fun main(args: Array<String>) {

    //与MutableList相似，特点是大小可变，类型不可变。
    val mainLine = setOf("迪士尼", "徐家汇", "桃蒲新村", "南翔", "马陆", "嘉定新城")
    val sublineJd = setOf("嘉定新城", "嘉定西", "嘉定北")
    val sublineKs = setOf("嘉定新城", "上海赛车场", "安亭", "花桥")
    val newsLines = setOf("麒麟路", "墨水湖北路")

    //将setOf转变为MutableSet
    val mnutableMainline = mainLine.union(sublineJd).union(sublineKs).toMutableSet()

    //末尾添加一个元素
    mnutableMainline.add("归山北麓")
    println(mnutableMainline)
    //添加一个setOf集合
    mnutableMainline.addAll(newsLines)
    println(mnutableMainline)
    //在集合里面查找是否相同的元素进行删除
    mnutableMainline.remove("归山北麓")
    println(mnutableMainline)
    //针对每个元素的长度，是否符合大于2的条件，进行打印
    println(mnutableMainline.filter { it.length > 2 }.joinToString())
    //针对每个元素进行二次 更改
    println(mnutableMainline.joinToString { "$it map" })
    //跳过前两位元素
    println(mnutableMainline.drop(2).joinToString())
    //只打印前2位元素
    println(mnutableMainline.take(2).joinToString())


}