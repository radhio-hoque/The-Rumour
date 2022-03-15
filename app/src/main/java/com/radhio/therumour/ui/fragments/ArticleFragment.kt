package com.radhio.therumour.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.radhio.therumour.R
import com.radhio.therumour.models.Article
import kotlinx.android.synthetic.main.article_fragment.*

class ArticleFragment : BaseFragment() {
//    val args

    companion object {
        private const val TAG = "ArticleFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article: Article = arguments?.getParcelable("article")!!
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
    }
}