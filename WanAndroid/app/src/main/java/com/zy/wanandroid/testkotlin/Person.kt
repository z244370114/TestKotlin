package com.zy.wanandroid.testkotlin


class Person(var name: String, var age: Int) {

    fun printlnformation() = println("name:${this.name},age:${this.age}")

    inner class StudentElement(id: String, name: String, age: Int, person: Person) {

        val person: Person = person
        val studentID: String = id
        val name: String = name
        val age: Int = age
        val studentInformation: String
            get() = " id:${this.studentID},name:${this.name},age:${this.age}"

        fun Person.sayHello() = println(" hello ,  my  name  is  ${this.name}")
        fun sayHello() = println(" hello ,  my  name  is  ${this.name}")

        fun letPersonSayHello() {
            person.sayHello()
            sayHello()
        }

    }

}

fun main(args: Array<String>) {

    var person = Person("周", 25)
    var student = person.StudentElement("1001", "子周", 25, person)
    println(student.studentInformation)
    student.letPersonSayHello()

}