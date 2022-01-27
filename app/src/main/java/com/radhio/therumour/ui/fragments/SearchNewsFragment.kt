package com.radhio.therumour.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.radhio.therumour.R
import com.radhio.therumour.viewmodels.SearchNewsViewModel

class SearchNewsFragment : Fragment(R.layout.search_news_fragment) {

    companion object {
        fun newInstance() = SearchNewsFragment()
    }

    private lateinit var viewModel: SearchNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchNewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}