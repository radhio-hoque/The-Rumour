package com.radhio.therumour.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.radhio.therumour.R
import com.radhio.therumour.adapters.NewsAdapter
import com.radhio.therumour.util.Resource
import kotlinx.android.synthetic.main.breaking_news_fragment.*

class BreakingNewsFragment : BaseFragment() {

    lateinit var newsAdapter: NewsAdapter

    companion object {
        private const val TAG = "BreakingNewsFragment"
        fun newInstance() = BreakingNewsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.breaking_news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        fetchDataFromViewModel();
    }

    private fun fetchDataFromViewModel() {
        viewModel.getBreakingNews("us").observe(viewLifecycleOwner, { response ->
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
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}