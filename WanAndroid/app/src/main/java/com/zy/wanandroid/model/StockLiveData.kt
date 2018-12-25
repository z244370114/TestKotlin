package com.zy.wanandroid.model

import android.arch.lifecycle.LiveData
import android.support.annotation.MainThread
import java.math.BigDecimal


class StockLiveData(symbol: String) : LiveData<BigDecimal>() {

//    private val mStockManager: StockManager = StockManager(symbol)

    private val mListener = { price: BigDecimal ->
        value = price
    }


    override fun onInactive() {


    }

    override fun onActive() {

    }


    companion object {

        private lateinit var sInstance: StockLiveData

        @MainThread
        fun get(symbol: String): StockLiveData {
            sInstance = if (::sInstance.isInitialized) sInstance else StockLiveData(symbol)
            return sInstance
        }

    }
}
