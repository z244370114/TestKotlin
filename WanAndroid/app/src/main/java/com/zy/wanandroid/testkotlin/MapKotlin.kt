package com.zy.wanandroid.testkotlin


fun main(args: Array<String>) {

    val mapOf = mapOf(
        Pair("PVG", "上海浦东国际机场"), Pair("WHTH", "武汉天河机场"),
        Pair("GZBYS", "广州白云山机场")
    )

    println(mapOf.toString())
    println(mapOf["PVG"])
    println(mapOf.entries)
    println(mapOf.keys.filter { it == "PVG" })
    println(mapOf.keys.map { it == "PVG" })
    println(mapOf.values)
    println(mapOf.containsKey("WHTH"))
    println(mapOf.containsValue("广州白云山机场"))
    println(mapOf.filterKeys { it.contains("W") })
    println(mapOf.filterValues { it.contains("机场") })
    println(mapOf.map { "机场代码：${it.key},机场全称：${it.value}" })

    println(mapOf.maxBy { it.value.length })
    println(mapOf.minBy { it.key.length })
    println(mapOf.toSortedMap())
    println(mapOf.toList())
    println(mapOf.toMutableMap())

}