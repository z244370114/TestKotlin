package com.zy.wanandroid.testkotlin.category


fun main(args: Array<String>) {

    val numberCompution = NumberCompution(10, 29) { x, y -> x + y }
    numberCompution.operation()
    numberCompution.operator = { x, y -> x * y }
    numberCompution.operation()


}

class NumberCompution(val numl: Int, val num2: Int, var operator: (Int, Int) -> Int) {

    fun operation() {
        println("VolumeShaper.Operation Result ${operator(numl, num2)}")
    }

}