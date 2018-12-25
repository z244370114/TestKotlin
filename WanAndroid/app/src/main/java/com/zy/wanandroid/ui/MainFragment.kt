//package com.zy.wanandroid.ui
//
//import android.app.Activity.RESULT_OK
//import android.arch.lifecycle.Observer
//import android.arch.lifecycle.ViewModelProviders
//import android.content.Intent
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.support.v7.widget.LinearLayoutManager
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import com.zy.wanandroid.R
//import com.zy.wanandroid.adapter.WordListAdapter
//import com.zy.wanandroid.model.MainViewModel
//import com.zy.wanandroid.model.Word
//import com.zy.wanandroid.model.WordViewModel
//import kotlinx.android.synthetic.main.main_fragment.*
//
//
//class MainFragment : Fragment() {
//
//    private lateinit var viewModel: MainViewModel
//
//    companion object {
//        private lateinit var wordModes: WordViewModel
//
//        fun newInstance(wordMode: WordViewModel): MainFragment {
//            val mainFragment = MainFragment()
//            wordModes = wordMode
//            return mainFragment
//        }
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        return inflater.inflate(R.layout.main_fragment, container, false)
//    }
//
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//
//        viewModel.data.observe(this, Observer { data ->
//            message.text = data
//        })
//
//        viewModel.mainDatas.observe(this, Observer { mainData ->
//            message.text = mainData.toString()
//        })
//
//        message.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(activity, viewModel.data.value, Toast.LENGTH_SHORT).show()
//                val intent = Intent(activity, NewWordActivity::class.java)
//                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
//            }
//        })
//
//
//        val adapter = WordListAdapter(activity)
//        recyclerview.adapter = adapter
//        recyclerview.layoutManager = LinearLayoutManager(activity)
//
//        wordModes.mAllWords.observe(this.activity!!, Observer { wordMode ->
//            adapter.setWords(wordMode)
//        })
//    }
//
//    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode === NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode === RESULT_OK) {
//            val word = Word(data!!.getStringExtra("com.example.android.wordlistsql.REPLY"))
//            wordModes.insert(word)
//        } else {
//            Toast.makeText(activity, "插入成功", Toast.LENGTH_LONG).show()
//        }
//    }
//
//}
