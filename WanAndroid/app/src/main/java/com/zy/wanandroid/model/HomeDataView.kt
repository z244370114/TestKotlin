package com.zy.wanandroid.model

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.zy.wanandroid.net.DataRequests
import com.zy.wanandroid.net.TestObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeDataView : AndroidViewModel {

    val listArticle by lazy { MutableLiveData<MutableList<ArticleData>>() }

    val listBannerData by lazy { MutableLiveData<BannerData>() }

    constructor(application: Application) : super(application)


    fun getListArticleData(page: Int = 0) {
        val listArticleData = DataRequests.apiService.getListArticleData(page)
        listArticleData.enqueue(object : Callback<BaseData<ArticleData>> {
            override fun onFailure(call: Call<BaseData<ArticleData>>, t: Throwable) {
                println("t = $t")
            }

            override fun onResponse(call: Call<BaseData<ArticleData>>, response: Response<BaseData<ArticleData>>) {
                val mutableList: MutableList<ArticleData> = response.body()!!.data!!.datas as MutableList<ArticleData>
                listArticle.value = mutableList
            }
        })
    }

    @SuppressLint("CheckResult")
    fun getlistBannerData() {
        val banner = DataRequests.apiService.getBanner()
//        banner.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<BannerData> {
//
//                override fun onComplete() {
//                    println("HomeDataView.onComplete")
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                    println("HomeDataView.onSubscribe")
//                }
//
//                override fun onNext(t: BannerData) {
//                    listBannerData.value = t
//                }
//
//                override fun onError(e: Throwable) {
//                    println("HomeDataView.onError")
//                }
//
//            })
        banner.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : TestObserver<BannerData>() {

                override fun onSuccess(data: BannerData) {
                    listBannerData.value = data
                }

                override fun onErrors(errorData: Throwable) {
                }

            })

    }
}


