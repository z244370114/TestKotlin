package com.zy.wanandroid.testkotlin.category


fun main(args: Array<String>) {

    println(A())

}


open class A {
    open var name: String = ""

    override fun toString(): String {
        return "A(name='$name')"
    }


}

class B : A() {
    override var name: String = ""
}
