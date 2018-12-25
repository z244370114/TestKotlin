package com.zy.wanandroid.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DataRequest {

    var retrofit: Retrofit? = null

    fun builder(baseUrl: String): Builder {
        return Builder(baseUrl)
    }

    class Builder(private val baseUrl: String) {

        fun build() {

            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

    }

}
