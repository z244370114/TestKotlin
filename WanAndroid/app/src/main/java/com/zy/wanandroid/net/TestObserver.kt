package com.zy.wanandroid.net

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *<p/>
 * 作者：zhouyuan on  2018/12/14 16:30
 *<p/>
 * 邮箱：244370114@qq.com
 * <p/>
 *
 */
abstract class TestObserver<T> : Observer<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onErrors(e)
    }

    abstract fun onSuccess(data: T)

    abstract fun onErrors(errorData: Throwable)

}