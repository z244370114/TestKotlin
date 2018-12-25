package com.zy.wanandroid.testkotlin.ten


class Outer {
    var color: String = " red "
    var size: Int = 30
    fun functionA() {
        print(" I  am  Outer!  \n ")
    }

    inner class Inter {

        var color: String = "blue"
        var size: Int = 20

        fun functionB() {
            print(" I  am  Inter!  \n ")
        }

        fun functionC() {
            val a = this@Outer.functionA()
        }

    }
}

fun main(args: Array<String>) {
    val outer = Outer()
    val inter = Outer().Inter()
    outer.functionA()
    inter.functionB()
    inter.functionC()

    val one = object : One(25), Three {
        override fun interfunction() {
            println("覆盖接口里面的 方法")
        }

        override fun classfunction() {
            super.classfunction()
            println("覆盖类里面的 方法")
        }
    }
    println(one.age)
    one.classfunction()
    one.interfunction()

    val two = object {
        val name = "周远"
        fun myfunction() {
            println("我的方法我自己写！")
        }
    }

    println(two.name)
    two.myfunction()

}

interface Three {
    fun interfunction()
}

open class One(age: Int) {
    open var age: Int = age
    open fun classfunction() {
        println("我是类里的方法")
    }
}