package com.zy.wanandroid.testkotlin.ten


//密封类
sealed class Fruit {
    class Apple : Fruit() {
        fun operate() = println("给妈妈吃")
    }

    class Banana : Fruit() {
        fun operate() = println("给爸爸吃")
    }

    class WaterMelon : Fruit() {
        fun operate() = println("给自己吃")
    }

}

fun operate(fruit: Fruit) = when (fruit) {
    is Fruit.Apple -> fruit.operate()
    is Fruit.Banana -> fruit.operate()
    is Fruit.WaterMelon -> fruit.operate()
    else -> null
}


fun main(args: Array<String>) {
    val banana = Fruit.Banana()
    operate(banana)

}