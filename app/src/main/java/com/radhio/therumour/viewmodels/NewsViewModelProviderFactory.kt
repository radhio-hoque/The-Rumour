package com.radhio.therumour.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.radhio.therumour.repositories.BreakingNewsRepository

/**
 * Created by Azmia Hoque Radhio on 2/7/2022.
 */
class NewsViewModelProviderFactory(
    private val breakingNewsRepository: BreakingNewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BreakingNewsViewModel() as T
    }
}