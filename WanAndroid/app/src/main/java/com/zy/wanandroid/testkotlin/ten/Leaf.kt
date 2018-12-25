package com.zy.wanandroid.testkotlin.ten


data class Leaf(val size: String, val color: String, val shape: String, val vein: Int) {

    override fun toString(): String = " Leaf ($size--$color--$shape--$vein)"
}

fun main(args: Array<String>) {

    val myleaf = Leaf("30", "GREEN", "circle", 57)
    val lsize = myleaf.size
    val lcolor = myleaf.color
    val lshape = myleaf.shape
    val lvein = myleaf.vein

    val (size, color, shape, vein) = myleaf

    println(myleaf.toString())

    println("lsize=$lsize,lcolor=$lcolor,lshape=$lshape,lvein=$lvein")

    println("size=$size,color=$color,shape=$shape,vein=$vein")

    val sizes = myleaf.component1()
    val colors = myleaf.component2()
    val shapes = myleaf.component3()
    val veins = myleaf.component4()

    println("sizes=$sizes,colors=$colors,shapes=$shapes,veins=$veins")

    val myleaf_chun = Leaf("30", "GREEN", "circle", 37)
    val myleaf_xia = myleaf_chun.copy(vein = 50)
    val myleaf_qiu = myleaf_xia.copy(color = "red")
    val myleaf_dong = myleaf_qiu.copy(size = "", color = "", shape = "", vein = 0)

    println("树叶的一生春夏秋冬")
    println("春季:$myleaf_chun")
    println("夏季:$myleaf_xia")
    println("秋季:$myleaf_qiu")
    println("冬季:$myleaf_dong")


}