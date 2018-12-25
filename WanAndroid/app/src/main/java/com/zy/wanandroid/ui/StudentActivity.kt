package com.zy.wanandroid.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zy.wanandroid.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentActivity : AppCompatActivity() {

    var cccc = CompositeDisposable()

//    private val studentViewModel by lazy(LazyThreadSafetyMode.NONE) {
//        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T = StudentViewModel(application) as T
//        }).get(StudentViewModel::class.java)
//    }

//    private val userViewModel by lazy(LazyThreadSafetyMode.NONE) {
//        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T = ViewModelUser(application) as T
//        }).get(ViewModelUser::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

//        val adapter = StudentAdapter()
//
//        recyclerview.adapter = adapter

//        studentViewModel.allStudents.observe(this, Observer {
//            adapter.submitList(it)
//            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
//        })


//        userViewModel.users.observe(this, Observer {
//            println(it.toString())
//            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
//        })
        var observable = Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<Long>() {

                override fun onComplete() {

                }

                override fun onNext(t: Long) {
                    println("t = $t")
                }

                override fun onError(e: Throwable) {

                }

            })
//        cccc.add(observable)

    }

    override fun onDestroy() {
        super.onDestroy()
//        cccc.clear()
    }
}
