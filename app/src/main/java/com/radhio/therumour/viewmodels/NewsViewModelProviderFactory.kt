package com.radhio.therumour.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.radhio.therumour.repositories.NewsRepository

/**
 * Created by Azmia Hoque Radhio on 2/7/2022.
 */
class NewsViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}