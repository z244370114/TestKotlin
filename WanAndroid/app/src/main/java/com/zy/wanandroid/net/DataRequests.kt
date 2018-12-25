package com.zy.wanandroid.net

import com.zy.wanandroid.ApiService
import com.zy.wanandroid.ApiUrl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class DataRequests {

    companion object {

        val instance: DataRequests
            get() = DataHolder.DATA_REQUESTS

        val apiService: ApiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiUrl.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    private object DataHolder {
        val DATA_REQUESTS = DataRequests()
    }


}

fun main(args: Array<String>) {


}