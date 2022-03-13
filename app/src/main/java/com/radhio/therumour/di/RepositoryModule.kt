package com.radhio.therumour.di

import com.radhio.therumour.db.ArticleDatabase
import com.radhio.therumour.repositories.BreakingNewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Azmia Hoque Radhio on 3/13/2022.
 */

@Module
class RepositoryModule(
) {
    @Singleton
    @Provides
    fun getBreakingNewsRepository(): BreakingNewsRepository {
        return BreakingNewsRepository()
    }
}