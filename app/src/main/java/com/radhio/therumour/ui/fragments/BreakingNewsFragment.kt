package com.radhio.therumour.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.radhio.therumour.R
import com.radhio.therumour.adapters.NewsAdapter
import com.radhio.therumour.util.Resource
import com.radhio.therumour.viewmodels.BreakingNewsViewModel
import com.radhio.therumour.viewmodels.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.breaking_news_fragment.*

class BreakingNewsFragment : BaseFragment() {

    lateinit var newsAdapter: NewsAdapter
    lateinit var breakingNewsViewModel : BreakingNewsViewModel

    companion object {
        private const val TAG = "BreakingNewsFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.breaking_news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelProviderFactory = NewsViewModelProviderFactory()
        breakingNewsViewModel = ViewModelProvider(this,viewModelProviderFactory)[BreakingNewsViewModel::class.java]
        setUpRecyclerView()
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putParcelable("article", it)
            }
            findNavController().navigate(R.id.action_breakingNewsFragment_to_articleFragment, bundle)
        }
        fetchDataFromViewModel();
    }

    private fun fetchDataFromViewModel() {
        breakingNewsViewModel.getBreakingNews("us").observe(viewLifecycleOwner, { response ->
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
        pbBreakingNews.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        pbBreakingNews.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}