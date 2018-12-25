package com.zy.wanandroid.testkotlin.ten

import kotlin.reflect.KProperty


class Oueself(mynameSX: String) {
    var mynameSX: String = mynameSX
    var weituoSX: String by AnotherClass()
    var boxSX: Box by BoxClass()
}

class BoxClass {
    operator fun getValue(oueself: Oueself, property: KProperty<*>): Box {
        return Box(20, "yuan")
    }

    operator fun setValue(oueself: Oueself, property: KProperty<*>, box: Box) {

    }

}


class AnotherClass {
    operator fun getValue(oueself: Any, property: KProperty<*>): String {
        return "$oueself 委托了 ${property.name} 属性给${this@AnotherClass}"
    }

    operator fun setValue(oueself: Any, property: KProperty<*>, s: String) {
        println("$oueself 的${property.name} 属性被我赋值 $s")
    }

}

fun main(args: Array<String>) {


    val oueself = Oueself("周远")
    println("未被委托的属性：${oueself.mynameSX} ")
    oueself.weituoSX = "周愉"
    println(oueself.weituoSX)
//    oueself.boxSX = Box(25, "tuoyuan")
    println(oueself.boxSX.size)


}