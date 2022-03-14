package com.radhio.therumour.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.radhio.therumour.R
import com.radhio.therumour.adapters.NewsAdapter
import com.radhio.therumour.util.Constants.Companion.SEARCH_NEWS_TIME_DELAY
import com.radhio.therumour.util.Resource
import com.radhio.therumour.viewmodels.NewsViewModelProviderFactory
import com.radhio.therumour.viewmodels.SearchNewsViewModel
import kotlinx.android.synthetic.main.breaking_news_fragment.*
import kotlinx.android.synthetic.main.search_news_fragment.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchNewsFragment : BaseFragment() {

    lateinit var newsAdapter: NewsAdapter
    lateinit var searchViewModel: SearchNewsViewModel

    companion object {
        private const val TAG = "SearchNewsFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.search_news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelProviderFactory = NewsViewModelProviderFactory()
        searchViewModel = ViewModelProvider(this,viewModelProviderFactory)[SearchNewsViewModel::class.java]
        setUpRecyclerView()
        var job : Job? = null
        etSearch.addTextChangedListener {
            job?.cancel()
            job = MainScope().launch {
                delay(SEARCH_NEWS_TIME_DELAY)
                it?.let {
                    if (it.toString().isNotEmpty()){
                        fetchDataFromViewModel(it.toString())
                    }
                }
            }
        }
    }

    private fun fetchDataFromViewModel(searchQuery: String) {
        searchViewModel.getSearchNews(searchQuery).observe(viewLifecycleOwner, { response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Log.e(TAG, "An Error occurred : $it", )
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        pbSearchNews.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        pbSearchNews.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView(){
        newsAdapter = NewsAdapter()
        rvSearchNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}