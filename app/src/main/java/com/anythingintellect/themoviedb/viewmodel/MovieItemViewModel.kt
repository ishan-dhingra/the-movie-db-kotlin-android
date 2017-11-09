package com.anythingintellect.themoviedb.viewmodel

import com.anythingintellect.themoviedb.model.Movie
import com.anythingintellect.themoviedb.util.Navigator

/**
 * Created by ishan.dhingra on 07/11/17.
 */
class MovieItemViewModel(val navigator: Navigator): BaseViewModel() {

    lateinit var movie: Movie

    fun onClick() {
        navigator.openMovieDetails(movie)
    }

    override fun dispose() {

    }

}