package com.zy.wanandroid.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.zy.wanandroid.ApiService
import com.zy.wanandroid.ApiUrl
import com.zy.wanandroid.R
import com.zy.wanandroid.model.*
import kotlinx.android.synthetic.main.activity_name.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NameActivity : AppCompatActivity() {

    private lateinit var mModel: NameViewModel
    private lateinit var mTestViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        mModel = ViewModelProviders.of(this).get(NameViewModel::class.java)
        mTestViewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        val nameObserver = Observer<String> {
            name.text = it
        }

        mModel.currentName.observe(this, nameObserver)

//        mModel.currentName.observeForever(nameObserver)

        mTestViewModel.mCurrent!!.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        mTestViewModel.liveDataMap.observe(this, Observer {
            Toast.makeText(this, "map$it", Toast.LENGTH_SHORT).show()
        })
        mTestViewModel.liveDataSwitch.observe(this, Observer {
            Toast.makeText(this, "switch$it", Toast.LENGTH_SHORT).show()
        })

        button.setOnClickListener {
            mTestViewModel.mCurrent!!.value = "11111111111111"
            mModel.currentName.postValue("123232")
        }
//        DataSource.Factory

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiUrl.BASE_URL)
            .build()
        val apiService = retrofit.create(ApiService::class.java)
        val listArticleData = apiService.getListArticleData(1)
        listArticleData.enqueue(object : Callback<BaseData<ArticleData>> {
            override fun onFailure(call: Call<BaseData<ArticleData>>, t: Throwable) {
                println("t = $t")
            }

            override fun onResponse(call: Call<BaseData<ArticleData>>, response: Response<BaseData<ArticleData>>) {
                val mutableList: MutableList<ArticleData> = response.body()!!.data!!.datas as MutableList<ArticleData>
            }
        })
    }


}
