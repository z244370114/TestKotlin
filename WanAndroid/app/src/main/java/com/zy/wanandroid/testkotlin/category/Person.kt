package com.zy.wanandroid.testkotlin.category


fun main(args: Array<String>) {

    val baby = Person(" MingHo ng ", 3)
    val parentl = Person(" DaMing ", 50)
    val parent2 = Person(" DaH ong ", 45)

    val child1 = Person("zhouyuan", 25, mutableListOf(parentl, parent2), mutableListOf(baby))
    child1.showYouselfInformation()
    child1.showParentsInformation()
    child1.showChildreninformation()

}


open class Person(name: String, age: Int) {

    constructor(name: String, age: Int, parents: MutableList<Person>, children: MutableList<Person>) : this(name, age) {
        parents.forEach { it.children.add(this) }
        children.forEach { it.parents.add(this) }
        this.parents.addAll(parents)
        this.children.addAll(children)
    }


    val name: String = name
    val age: Int = age

    var parents = mutableListOf<Person>()
    var children = mutableListOf<Person>()

    fun showYouselfInformation() = println("名字$name，年龄$age")

    fun showParentsInformation() = parents.forEach { println("名字${it.name}，年龄${it.age}") }

    fun showChildreninformation() = children.forEach { println("名字${it.name}，年龄${it.age}") }

}

class Student : Person {
    constructor():super("zhou",25){

    }

    var teacherNumbers: Int = 0
    var schoolName: String = ""
}

class Worker : Person("zhou", 25) {
    var nameOfWorkPlace: String = ""
    var salary: Int = 0
}