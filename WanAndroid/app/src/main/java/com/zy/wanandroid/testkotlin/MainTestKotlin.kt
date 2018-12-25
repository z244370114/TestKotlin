package com.zy.wanandroid.testkotlin

import java.util.concurrent.Executors


fun main(args: Array<String>) {

    val executor = Executors.newFixedThreadPool(4)

    for (i in 1..10) {

        executor.submit {
            println("$i on thread${Thread.currentThread()}")
        }

    }

}