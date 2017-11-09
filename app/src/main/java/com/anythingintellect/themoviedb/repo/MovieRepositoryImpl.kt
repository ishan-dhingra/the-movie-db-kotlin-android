package com.anythingintellect.themoviedb.repo

import android.util.Log
import com.anythingintellect.themoviedb.model.MovieResponse
import com.anythingintellect.themoviedb.network.MovieAPI
import com.anythingintellect.themoviedb.util.Constant
import com.anythingintellect.themoviedb.util.toReleaseFormat
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by ishan.dhingra on 06/11/17.
 */
class MovieRepositoryImpl @Inject constructor(var movieAPI: MovieAPI) : MovieRepository {

    override fun getMovies(page: Int, date: Date): Observable<MovieResponse> {
        return movieAPI.discover(page = page, date = date.toReleaseFormat())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}