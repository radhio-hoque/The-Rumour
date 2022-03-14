package com.radhio.therumour.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.radhio.therumour.R
import com.radhio.therumour.db.ArticleDatabase
import com.radhio.therumour.repositories.BreakingNewsRepository
import com.radhio.therumour.viewmodels.BreakingNewsViewModel
import com.radhio.therumour.viewmodels.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private val navController by lazy {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.newsNavHostFragment) as NavHostFragment

        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        bottomNavigationView.setupWithNavController(navController)
        initiateViewModel()
    }
    
    private fun initiateViewModel(){
       //val newsRepository = BreakingNewsRepository(ArticleDatabase(this))
        val newsRepository = BreakingNewsRepository()
    }
}