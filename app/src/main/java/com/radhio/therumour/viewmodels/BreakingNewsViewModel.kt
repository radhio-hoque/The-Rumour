package com.radhio.therumour.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radhio.therumour.models.NewsResponse
import com.radhio.therumour.repositories.NewsRepository
import com.radhio.therumour.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class BreakingNewsViewModel(
   private val newsRepository: NewsRepository
) : ViewModel() {

   init {
      fetchBreakingNews("us")
   }

   val breakingNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
   private val breakingNewsPage = 1

   fun fetchBreakingNews(countryCode: String) = viewModelScope.launch {
         breakingNews.postValue(Resource.Loading())
         val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
         breakingNews.postValue(handleBreakingNewsResponse(response))
      }

   private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse>{
      if (response.isSuccessful){
         response.body()?.let {
            return Resource.Success(it)
         }
      }
      return Resource.Error(response.message())
   }

}