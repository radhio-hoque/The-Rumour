package com.radhio.therumour.di

import com.radhio.therumour.repositories.SearchNewsRepository
import com.radhio.therumour.viewmodels.BreakingNewsViewModel
import com.radhio.therumour.viewmodels.SearchNewsViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Azmia Hoque Radhio on 3/13/2022.
 */
@Singleton
@Component(modules = [RepositoryModule::class])
interface ViewModelComponent {
    fun inject(viewModel: BreakingNewsViewModel)
    fun inject(viewModel: SearchNewsViewModel)
}