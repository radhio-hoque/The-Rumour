package com.radhio.therumour.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radhio.therumour.app.NewsController
import com.radhio.therumour.models.NewsResponse
import com.radhio.therumour.repositories.SearchNewsRepository
import com.radhio.therumour.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class SearchNewsViewModel(
    //private val breakingNewsRepository: BreakingNewsRepository
) : ViewModel() {

    @Inject
    lateinit var searchNewsRepository : SearchNewsRepository
    private var searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private var searchNewsPage : Int = 1

    init {
        NewsController.getInstance().getViewModelComponent().inject(this)
    }

    private fun fetchSearchNews(searchQuery: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        val response = searchNewsRepository.getSearchNews(searchQuery, searchNewsPage)
        searchNews.postValue(handleSearchNewsResponse(response))
    }

    fun getSearchNews(searchQuery: String) : MutableLiveData<Resource<NewsResponse>> {
        fetchSearchNews(searchQuery)
        return searchNews
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

}