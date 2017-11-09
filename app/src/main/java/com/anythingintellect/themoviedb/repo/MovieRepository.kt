package com.anythingintellect.themoviedb.repo

import com.anythingintellect.themoviedb.model.MovieResponse
import io.reactivex.Observable
import java.util.*

/**
 * Created by ishan.dhingra on 06/11/17.
 */
interface MovieRepository {

    fun getMovies(page: Int, date: Date): Observable<MovieResponse>

}