//package com.zy.wanandroid.model;
//
//import android.app.Application;
//import android.arch.lifecycle.AndroidViewModel;
//import android.arch.lifecycle.LiveData;
//import android.support.annotation.NonNull;
//import com.zy.wanandroid.room.WordRepository;
//
//import java.util.List;
//
///**
// * @author Administrator
// */
//public class WordViewModel extends AndroidViewModel {
//
//    public WordRepository mRepository;
//
//    public LiveData<List<Word>> mAllWords;
//
//    public WordViewModel(@NonNull Application application) {
//        super(application);
//        mRepository = new WordRepository(application);
//        mAllWords = mRepository.getAllWords();
//    }
//
//    public void insert(Word word) {
//        mRepository.insert(word);
//    }
//
//}
