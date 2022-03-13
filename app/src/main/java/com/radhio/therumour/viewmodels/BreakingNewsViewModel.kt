package com.radhio.therumour.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radhio.therumour.app.NewsController
import com.radhio.therumour.models.NewsResponse
import com.radhio.therumour.repositories.BreakingNewsRepository
import com.radhio.therumour.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class BreakingNewsViewModel(
    //private val breakingNewsRepository: BreakingNewsRepository
) : ViewModel() {

    @Inject
    lateinit var breakingNewsRepository : BreakingNewsRepository
    private var breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private var breakingNewsPage : Int = 1

    init {
        NewsController.getInstance().getViewModelComponent().inject(this)
    }

    private fun fetchBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = breakingNewsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    fun getBreakingNews(countryCode: String) : MutableLiveData<Resource<NewsResponse>>{
        fetchBreakingNews(countryCode)
        return breakingNews
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

}