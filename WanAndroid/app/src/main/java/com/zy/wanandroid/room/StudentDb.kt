package com.zy.wanandroid.room

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.zy.wanandroid.dao.StudentDao
import com.zy.wanandroid.model.Student
import com.zy.wanandroid.utils.ioThread

@Database(entities = [Student::class], version = 1)
abstract class StudentDb : RoomDatabase() {

    abstract fun studentDao(): StudentDao

//    abstract fun userDao(): UserDao

    companion object {
        private var instance: StudentDb? = null

        @Synchronized
        fun get(context: Context): StudentDb {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDb::class.java, "StudentDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            ioThread {
                                get(context).studentDao().insert(
                                    CHEESE_DATA.map { Student(id = 0, name = it) })
//                                get(context).userDao().insert(
//                                    CHEESE_DATA.map {
//                                        User(
//                                            id = 0,
//                                            userName = it,
//                                            age = 12,
//                                            sex = "男",
//                                            picture = "1"
//                                        )
//                                    })
                            }
                        }
                    })
                    .build()
            }
            return instance!!
        }
    }
}

private val CHEESE_DATA = arrayListOf(
    "1111111111111111111111111",
    "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
    "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale",
    "Aisy Cendre", "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
    "Ami du Chambertin", "Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro", "Appenzell",
    "Aragon", "Ardi Gasna", "Ardrahan", "Armenian String", "Aromes au Gene de Marc",
    "Asadero", "Asiago", "Aubisque Pyrenees", "Autun", "Avaxtskyr", "Baby Swiss",
    "Babybel", "Baguette Laonnaise", "Bakers", "Baladi", "Balaton", "Bandal", "Banon",
    "Barry's Bay Cheddar", "Basing", "Basket Cheese", "Bath Cheese", "Bavarian Bergkase",
    "Baylough", "Beaufort", "Beauvoorde", "Beenleigh Blue", "Beer Cheese", "Bel Paese",
    "Bergader", "Bergere Bleue", "Berkswell", "Beyaz Peynir", "Bierkase", "Bishop Kennedy",
    "Blarney", "Bleu d'Auvergne", "Bleu de Gex", "Bleu de Laqueuille",
    "Bleu de Septmoncel", "Bleu Des Causses", "Blue", "Blue Castello", "Blue Rathgore",
    "Blue Vein (Australian)", "Blue Vein Cheeses", "Bocconcini", "Bocconcini (Australian)"
)

