package com.anythingintellect.themoviedb.util

import com.anythingintellect.themoviedb.model.Movie

/**
 * Created by ishan.dhingra on 06/11/17.
 */
interface Navigator {

    fun openMovieDetails(movie: Movie)

}