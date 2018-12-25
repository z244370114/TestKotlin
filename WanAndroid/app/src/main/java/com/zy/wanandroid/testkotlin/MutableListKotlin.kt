package com.zy.wanandroid.testkotlin


fun main(args: Array<String>) {

    val nollstations = mutableListOf(
        "嘉定北", "徐家汇", "商翔", "桃浦新村", "徐家汇",
        "上海四站", "罗山路", "池士尼", "嘉定新城", "徐家汇", "桃浦新村"
    )

    val newStations = mutableListOf("花桥")
    nollstations.add("嘉定新城") //末尾增加元素
    nollstations.addAll(newStations)//添加序列
    println("nollstations = $nollstations")
    nollstations.remove("嘉定新城")//从第一个元素进行匹配，如果相同进行删除
    println("nollstations = $nollstations")
    nollstations.removeAt(0)//根据列表的index下标，然后进行删除
    println("nollstations = $nollstations")
    nollstations.set(0, "替换徐家汇")//根据列表index下标，进行替换
    nollstations[0] = "替换徐家汇"//根据列表index下标，进行替换
    println("nollstations = $nollstations")
    val subList = nollstations.subList(3, 6)//从下标为4至7的位置进行打印
    println(subList)
    println(subList.map { "ceshi$it" }) //针对列表集合，每个元素进行转换
    println(subList.maxBy { s-> s.length}) //针对列表集合，打印元素最长的那个元素
//    println(nollstations.removeAll(nollstations))//清除所有列表集合元素
    println(nollstations.clear())//清除所有列表集合元素

}