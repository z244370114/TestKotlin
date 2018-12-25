package com.zy.wanandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit


class StartActivity : AppCompatActivity() {

    var mDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
//        UserManger.context = this
//        val userManger = UserManger.getInstance()
        Observable.timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Long> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    mDisposable = d
                }

                override fun onNext(t: Long) {
                    finish()
//                    val intent = Intent(this@StartActivity, MainActivity::class.java)
//                    startActivity(intent)
                    ARouter.getInstance().build("/ui/mainActivity").navigation()
                }

                override fun onError(e: Throwable) {

                }

            })


    }

    override fun onDestroy() {
        mDisposable!!.dispose()
        super.onDestroy()
    }


}
