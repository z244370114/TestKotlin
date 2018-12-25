package com.zy.wanandroid.testkotlin.ten


open class Father(var height: Int, var weight: Int) {

    open val money: Int = 300

    open fun eat() {
        print(" I  like  eat  fruit!\n ")
    }

    final fun action() {
        println("I can run!")
    }

}

class Son(height: Int, weight: Int) : Father(height, weight) {

    override val money: Int = 100

    override fun eat() {
        super.eat()
        println("I like eat to mee!")
    }

}


fun main(args: Array<String>) {

    val father = Father(175, 140)
    val son = Son(180, 145)
    println(father.height)
    println(son.height)
    father.action()
    son.action()
    son.eat()
}
