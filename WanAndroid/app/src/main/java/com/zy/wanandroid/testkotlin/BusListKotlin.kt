package com.zy.wanandroid.testkotlin


fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5)
    println(list.any { it % 2 == 0 })
    println(list.any { it > 8 })
    println(list.all { it % 2 == 0 })
    println(list.all { it > 8 })
    println(list.count { it % 2 == 0 })

    list.forEach { print("$it ") }

    list.forEachIndexed { index, i -> print("$index  ") }
    println()
    println(list.max())
    println(list.min())
    println(list.none { it > 3 })
    println(list.reduce { total, next -> total + next })

    println(list.drop(2))
    println(list.dropWhile { it < 5 })
    println(list.dropLastWhile { it > 3 })

    println(list.take(3))
    println(list.takeLast(3))
    println(list.takeWhile { it < 3 })

    println(list.filter { it <= 3 })
    println(list.filterNot { it % 2 == 0 })
    println(list.slice(listOf(0, 2, 4)))
    println(list.slice(0..2))

    println(list.flatMap { listOf(it, it + 1) })

    println(list.groupBy { if (it % 2 == 0) "偶数" else "奇数" })

    println(list.map { it * 2 })

    println(list.contains(7))

    println(list.elementAt(2))

    println(list.elementAtOrElse(7) { it * 2 })

    println(list.elementAtOrNull(7))
    println(list.first { it % 2 == 0 })
    println(list.firstOrNull { it % 8 == 0 })

    println(list.indexOf(5))
    println(list.indexOfFirst { it % 2 == 0 })
    println(list.indexOfLast { it % 2 == 0 })


//    println(listOf.single { it % 6 == 0 })
    println(list.singleOrNull { it % 6 == 0 })

    val message = list.partition { it > 3 }.first
    println(message[0])
    println(list.zip(message))

    val list3 = listOf(3, 4, 1, 0, 2)
    println(list3.sorted())
    println(list3.sortedDescending())



}