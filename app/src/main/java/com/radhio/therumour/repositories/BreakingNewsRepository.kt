package com.radhio.therumour.repositories

import com.radhio.therumour.endpoints.BreakingNewsAPI
import com.radhio.therumour.services.RetrofitInstance
import com.radhio.therumour.util.Constants

/**
 * Created by Azmia Hoque Radhio on 2/7/2022.
 */

class BreakingNewsRepository(
//    private val db: ArticleDatabase
) {
    private val breakingNewsService: BreakingNewsAPI by lazy {
        RetrofitInstance.retrofit.create(BreakingNewsAPI::class.java)
    }

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        breakingNewsService.getBreakingNews(countryCode, pageNumber, Constants.API_KEY)
}