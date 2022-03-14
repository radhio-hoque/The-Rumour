package com.radhio.therumour.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Azmia Hoque Radhio on 2/7/2022.
 */
class NewsViewModelProviderFactory(
    //private val breakingNewsRepository: BreakingNewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BreakingNewsViewModel::class.java)) {
            return BreakingNewsViewModel() as T
        } else if (modelClass.isAssignableFrom(SearchNewsViewModel::class.java)){
            return SearchNewsViewModel() as T
        }
        return null as T
    }
}