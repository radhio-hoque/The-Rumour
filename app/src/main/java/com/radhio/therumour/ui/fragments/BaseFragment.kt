package com.radhio.therumour.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.radhio.therumour.ui.NewsActivity
import com.radhio.therumour.viewmodels.NewsViewModel

/**
 * Created by Azmia Hoque Radhio on 2/7/2022.
 */
abstract class BaseFragment : Fragment() {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).newsViewModel
    }
}