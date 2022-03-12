package com.radhio.therumour.repositories

import com.radhio.therumour.db.ArticleDatabase
import com.radhio.therumour.endpoints.BreakingNewsAPI
import com.radhio.therumour.services.RetrofitInstance
import com.radhio.therumour.util.Constants

/**
 * Created by Azmia Hoque Radhio on 2/7/2022.
 */
class NewsRepository(
    private val db: ArticleDatabase
) {
    private val api by lazy {
        RetrofitInstance.retrofit.create(BreakingNewsAPI::class.java)
    }

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber, Constants.API_KEY)
}