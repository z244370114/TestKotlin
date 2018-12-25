package com.zy.wanandroid.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.Gson
import com.zy.wanandroid.ApiUrl
import com.zy.wanandroid.R
import com.zy.wanandroid.model.ArticleData
import com.zy.wanandroid.model.BaseData
import com.zy.wanandroid.model.HomeDataView
import com.zy.wanandroid.net.DownloadListener
import com.zy.wanandroid.net.DownloadResponseBody
import kotlinx.android.synthetic.main.main_activity.*
import okhttp3.*
import java.io.*
import java.nio.channels.FileChannel

@Route(path = "/ui/mainActivity")
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var homeDataView: HomeDataView? = null

    var page = 0

    var startSize: Long = 0

    val downloadListener = object : DownloadListener {
        override fun loading(i: Long) {
            println("javaClass i = $i")
            startSize = i
        }

        override fun complete() {
            println("javaClass = 下载完成")
        }
    }

    var downloadCall: Call? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        bnv_bar.setOnNavigationItemSelectedListener(this)
        bnv_bar.itemIconTintList = null

        homeDataView = ViewModelProviders.of(this).get(HomeDataView::class.java)

        homeDataView!!.listArticle.observe(this, Observer {
            var string = StringBuffer()
            for (i in 0 until it!!.size) {
                string.append(it[i].title + "\n")
            }
            text1.text = string
        })
        homeDataView!!.listBannerData.observe(this, Observer {
            var string = StringBuffer()
            val data = it!!.data
            for (i in 0 until data!!.size) {
                string.append(data[i].title + "\n")
            }
            text1.text = string
        })
        loadList()

        text1.setOnClickListener {
            //            val intent = Intent(this@MainActivity, StudentActivity::class.java)
//            startActivity(intent)
            pause()
        }
        downloadCall = newCall(startSize)
    }

    fun pause() {
        downloadCall!!.cancel()
    }

    private fun save(response: Response, startSize: Long) {
        val body = response.body()
        val contentLength = body!!.contentLength()
        if (contentLength.toInt() == 0) {
            downloadListener.complete()
        } else {
            downloadListener.loading(contentLength)
        }

        var ins: InputStream? = null
        var randomAccessFile: RandomAccessFile? = null
        var bis: BufferedInputStream? = null
        val buff = ByteArray(2048)
        var len = 0
        var channelOut: FileChannel? = null

        ins = body.byteStream()
        bis = BufferedInputStream(ins)

        val file = getFile()
        // 随机访问文件，可以指定断点续传的起始位置
        randomAccessFile = RandomAccessFile(file, "rwd")
        channelOut = randomAccessFile.channel
        var mappedByteBuffer = channelOut.map(FileChannel.MapMode.READ_WRITE, startSize, contentLength)

//        randomAccessFile.seek(0)
        while (ins.read(buff).apply { len = this } > 0) {
//            randomAccessFile.write(buff, 0, len)
            mappedByteBuffer.put(buff, 0, len)
        }
        try {
            if (ins != null) {
                ins.close()
            }
            if (bis != null) {
                bis.close()
            }
            if (channelOut != null) {
                channelOut.close()
            }
            if (randomAccessFile != null) {
                randomAccessFile.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadList() {

        val request = Request.Builder()
            .url("http://www.wanandroid.com/project/list/1/json?cid=294")
            .build()
        val client = OkHttpClient.Builder().build()
        val newCall = client.newCall(request)

        newCall.enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val string = response.body()!!.string()
                println("response = $string")
                val gson = Gson()
                val javaClass = BaseData<ArticleData>().javaClass
                val baseData = gson.fromJson(string, javaClass)
                val toJson = gson.toJson(baseData)
                println(toJson.toString())
            }

        })

    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_one -> {
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                page++
                homeDataView!!.getListArticleData(page)
            }
            R.id.action_tow -> {
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
                homeDataView!!.getlistBannerData()
            }
            R.id.action_three -> {
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
//                loadList()
                download(startSize)
            }
        }
        return true
    }


    fun newCall(startSize: Long): Call {
        var request = Request.Builder()
            .url(ApiUrl.DOWNLOAD)
            .header("RANGE", "bytes=$startSize")
            .build()

        // 重写ResponseBody监听请求
        val interceptor = Interceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            originalResponse.newBuilder()
                .body(DownloadResponseBody(originalResponse, downloadListener, startSize))
                .build()
        }

        val dlOkhttp = OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)

        val newCall = dlOkhttp.build().newCall(request)
        return newCall
    }

    fun download(startSize: Long) {
        downloadCall = newCall(startSize)

        downloadCall!!.enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                save(response, startSize)
            }

        })

    }

    private fun getFile(): File {
        var root = Environment.getExternalStorageDirectory().path
        return File(root, "updateDemo.apk")
    }

    private fun getFileStart(): Long {
        var root = Environment.getExternalStorageDirectory().path
        return File(root, "updateDemo.apk").length()
    }


}
