package com.radhio.therumour.app

import android.app.Application
import com.radhio.therumour.di.DaggerViewModelComponent
import com.radhio.therumour.di.ViewModelComponent

/**
 * Created by Azmia Hoque Radhio on 3/13/2022.
 */

open class NewsController : Application(){

    private var viewModelComponent: ViewModelComponent = DaggerViewModelComponent.create()

    companion object{
        private var newsController: NewsController? = null
        @Synchronized
        fun getInstance(): NewsController {
            if (newsController==null){
                newsController = NewsController()
            }
            return newsController as NewsController
        }
    }

    fun getViewModelComponent(): ViewModelComponent {
        return viewModelComponent
    }
}