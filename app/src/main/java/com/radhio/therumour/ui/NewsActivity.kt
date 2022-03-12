package com.radhio.therumour.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.radhio.therumour.R
import com.radhio.therumour.db.ArticleDatabase
import com.radhio.therumour.repositories.NewsRepository
import com.radhio.therumour.viewmodels.BreakingNewsViewModel
import com.radhio.therumour.viewmodels.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel : BreakingNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
        initiateViewModel()
    }
    
    private fun initiateViewModel(){
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(BreakingNewsViewModel::class.java)
    }
}