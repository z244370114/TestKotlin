package com.zy.wanandroid

import com.zy.wanandroid.model.ArticleData
import com.zy.wanandroid.model.BannerData
import com.zy.wanandroid.model.BaseData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {


    @GET("/article/list/{page}/json")
    fun getListArticleData(@Path("page") page: Int): Call<BaseData<ArticleData>>

    @GET("/banner/json")
    fun getBanner(): Observable<BannerData>

    @GET("/project/list/{page}/json")
    fun getListData(@Path("page") page: Int, @Query("cid") cid: Int): Call<BaseData<ArticleData>>

}