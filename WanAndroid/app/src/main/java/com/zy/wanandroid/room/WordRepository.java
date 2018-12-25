//package com.zy.wanandroid.room;
//
//import android.app.Application;
//import android.arch.lifecycle.LiveData;
//import android.os.AsyncTask;
//import com.zy.wanandroid.dao.WordDao;
//import com.zy.wanandroid.model.Word;
//
//import java.util.List;
//
///**
// * <p/>
// * 作者：zhouyuan on  2018/11/23 15:03
// * <p/>
// * 邮箱：244370114@qq.com
// * <p/>
// */
//public class WordRepository {
//    private WordDao mWordDao;
//    private LiveData<List<Word>> mAllWords;
//
//    public WordRepository(Application application) {
//        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
//        mWordDao = db.wordDao();
//        mAllWords = mWordDao.getAllWords();
//    }
//
//    public LiveData<List<Word>> getAllWords() {
//        return mAllWords;
//    }
//
//
//    public void insert(Word word) {
//        new insertAsyncTask(mWordDao).execute(word);
//    }
//
//    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {
//
//        private WordDao mAsyncTaskDao;
//
//        insertAsyncTask(WordDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final Word... params) {
//            mAsyncTaskDao.insert(params[0]);
//            return null;
//        }
//    }
//}
