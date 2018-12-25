package com.zy.wanandroid.testkotlin.ten

interface Shangji {
    fun getTask()
}

class Me(name: String) : Shangji {
    var name = name
    override fun getTask() {
        println("上级布置的任务给${this.name}，他要委托个别人")
    }
}

class AnotherOne(ones: Shangji) : Shangji by ones

class ZhouYuOne(ones: Shangji) : Shangji by ones

class ZhouYuanOne(ones: Me) : Shangji by ones

//只有接口才能进行委托
fun main(args: Array<String>) {


    var one = Me("小明")

    AnotherOne(one).getTask()

    var ones = Me("周愉")

    ZhouYuOne(ones).getTask()

    ZhouYuanOne(ones).getTask()


}