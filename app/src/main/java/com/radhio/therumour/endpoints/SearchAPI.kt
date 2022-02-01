package com.radhio.therumour.endpoints

import com.radhio.therumour.models.NewsResponse
import com.radhio.therumour.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Azmia Hoque Radhio on 2/1/2022.
 */
interface SearchAPI {
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery : String,
        @Query("page") pageNumber : Int = 1,
        @Query("apiKey") apiKey : String = Constants.API_KEY
    ) : Response<NewsResponse>
}