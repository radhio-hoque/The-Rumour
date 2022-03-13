package com.radhio.therumour.services

import com.radhio.therumour.endpoints.BreakingNewsAPI
import com.radhio.therumour.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Azmia Hoque Radhio on 2/1/2022.
 */
class RetrofitInstance {
    companion object {
        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(callOkHttpClint())
                .build()
        }

        private val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        private fun getLoggingInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return loggingInterceptor
        }

        private fun callOkHttpClint(): OkHttpClient {
            httpClient.addInterceptor(getLoggingInterceptor())
            return httpClient.build()
        }
    }
}