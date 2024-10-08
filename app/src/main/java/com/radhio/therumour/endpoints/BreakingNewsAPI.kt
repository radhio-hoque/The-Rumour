package com.radhio.therumour.endpoints

import com.radhio.therumour.models.NewsResponse
import com.radhio.therumour.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Azmia Hoque Radhio on 2/1/2022.
 */

interface BreakingNewsAPI {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode : String = "us",
        @Query("page") pageNumber : Int = 1,
        @Query("apiKey") apiKey : String = ""
    ) : Response<NewsResponse>
}