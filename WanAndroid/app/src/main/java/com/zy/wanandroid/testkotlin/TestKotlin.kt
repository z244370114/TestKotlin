package com.zy.wanandroid.testkotlin


fun main(args: Array<String>) {

    val max = max(123, 23)
    println("max = ${max}")
    val person = Person("周远",25)
    println("person = ${person.name}")
    person.name = "11111111"
    println("person = ${person.name}")

    val rectangle = Rectangle(10, 100)
    println("rectangle = ${rectangle.isSquare}")

    println(createRectangle().isSquare)

    arrlistTest()

    arrayInt()



//    val psercentage = 101
//    if (psercentage !in 0..100) {
//        throw IllegalArgumentException("$psercentage")
//    }


}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
