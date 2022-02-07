package com.radhio.therumour.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.radhio.therumour.R

class ArticleFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ):
            View? {
        viewModel
        return inflater.inflate(R.layout.article_fragment, container, false)
    }
}