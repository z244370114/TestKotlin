//package com.zy.wanandroid.room;
//
//
//import android.arch.persistence.db.SupportSQLiteDatabase;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.support.annotation.NonNull;
//
//import com.zy.wanandroid.dao.WordDao;
//import com.zy.wanandroid.model.Word;
//
//
///**
// * @author Administrator
// */
////@Database(entities = {Word.class}, version = 1)
//public abstract class WordRoomDatabase extends RoomDatabase {
//
//    public abstract WordDao wordDao();
//
//    private static volatile WordRoomDatabase INSTANCE;
//
//    private static RoomDatabase.Callback sRoomDatabaseCallback =
//            new RoomDatabase.Callback() {
//                @Override
//                public void onOpen(@NonNull SupportSQLiteDatabase db) {
//                    super.onOpen(db);
//                    new PopulateDbAsync(INSTANCE)
//                            .execute();
//                }
//            };
//
//
//    public static WordRoomDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (WordRoomDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            WordRoomDatabase.class, "word_database")
//                            .fallbackToDestructiveMigration()
//                            .addCallback(sRoomDatabaseCallback)
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final WordDao mDao;
//
//        PopulateDbAsync(WordRoomDatabase db) {
//            mDao = db.wordDao();
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            mDao.deleteAll();
//            Word word = new Word("Hello");
//            mDao.insert(word);
//            word = new Word("World");
//            mDao.insert(word);
//            return null;
//        }
//
//    }
//
//
//
//
//}
