package com.zy.wanandroid.testkotlin


fun main(args: Array<String>) {

    //特点是大小固定，元素类型也不可变
    val mainLine = setOf("迪士尼", "徐家汇", "桃蒲新村", "南翔", "马陆", "嘉定新城")
    val sublineJd = setOf("嘉定新城", "嘉定西", "嘉定北")
    val sublineKs = setOf("嘉定新城", "上海赛车场", "安亭", "花桥")
    //集合数据大小
    println(mainLine.size)
    //集合数据大小
    println(mainLine.count())
    //匹配集合里面是否有参数 返回 true或者false
    println(mainLine.contains("迪士尼"))
    //打印集合元素
    println(mainLine.toTypedArray().joinToString())
    //打印集合元素
    println(mainLine.joinToString())
    //匹配mainLine集合是否完全包含sublineJd集合 返回 true或false
    println(mainLine.containsAll(sublineJd))
    println((mainLine + sublineJd).containsAll(sublineJd))
    println((mainLine + sublineJd).containsAll(mainLine))
    //查询两个集合中交集的部分
    println(mainLine.intersect(sublineJd))
    println(mainLine.intersect(sublineKs))
    println(sublineJd.intersect(sublineKs))

    //排除一个集合与另一个集合交集部分
    println(mainLine.subtract(sublineJd))
    println(mainLine.subtract(sublineKs))
    println(sublineJd.subtract(sublineKs))

    //合并两个集合
    println(mainLine.union(sublineJd).union(sublineKs))

    //算出主线分别于两条支线的补集
    println(mainLine.union(sublineJd) - mainLine.intersect(sublineJd))
    println(mainLine.union(sublineKs) - mainLine.intersect(sublineKs))

}