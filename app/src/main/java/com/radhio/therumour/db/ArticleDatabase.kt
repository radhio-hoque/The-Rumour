package com.radhio.therumour.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.radhio.therumour.models.Article

/**
 * Created by Azmia Hoque Radhio on 2/1/2022.
 */

@Database(
    entities = [Article::class],
    version = 1,
)

@TypeConverters(Convertors::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var dbInstance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = dbInstance ?:
        synchronized(LOCK) {
            dbInstance ?: createDatabase(context).also { dbInstance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }

}