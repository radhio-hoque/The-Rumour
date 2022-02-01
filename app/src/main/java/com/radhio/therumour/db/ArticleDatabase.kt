package com.radhio.therumour.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.radhio.therumour.models.Article

/**
 * Created by Azmia Hoque Radhio on 2/1/2022.
 */
@Database(
    entities = [Article::class],
    version = 1,
)
abstract class ArticleDatabase : RoomDatabase(){
    
}