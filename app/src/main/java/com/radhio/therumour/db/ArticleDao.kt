package com.radhio.therumour.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.radhio.therumour.models.Article

/**
 * Created by Azmia Hoque Radhio on 2/1/2022.
 */
@Dao
interface ArticleDao {
    @Insert(onConflict = REPLACE)
    suspend fun upsert(article: Article) : Long

    @Query("SELECT * from articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Delete()
    suspend fun deleteArticle(article: Article)
}