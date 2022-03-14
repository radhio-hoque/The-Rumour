package com.radhio.therumour.repositories

import com.radhio.therumour.endpoints.SearchNewsAPI
import com.radhio.therumour.services.RetrofitInstance
import com.radhio.therumour.util.Constants

/**
 * Created by Azmia Hoque Radhio on 3/14/2022.
 */
class SearchNewsRepository {

    private val searchNewsService: SearchNewsAPI by lazy {
        RetrofitInstance.retrofit.create(SearchNewsAPI::class.java)
    }

    suspend fun getSearchNews(searchQuery: String, pageNumber: Int) =
        searchNewsService.searchForNews(searchQuery, pageNumber, Constants.API_KEY)
}