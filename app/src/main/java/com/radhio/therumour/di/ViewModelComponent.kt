package com.radhio.therumour.di

import com.radhio.therumour.viewmodels.BreakingNewsViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Azmia Hoque Radhio on 3/13/2022.
 */
@Singleton
@Component(modules = [RepositoryModule::class])
interface ViewModelComponent {
    fun inject(viewModel: BreakingNewsViewModel)
}