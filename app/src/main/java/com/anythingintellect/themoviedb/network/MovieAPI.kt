package com.anythingintellect.themoviedb.network

import com.anythingintellect.themoviedb.model.MovieResponse
import com.anythingintellect.themoviedb.util.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ishan.dhingra on 06/11/17.
 */
interface MovieAPI {
    @GET("/3/discover/movie")
    fun discover(@Query("release_date.gte") date: String,
                 @Query("page") page: Int,
                 @Query("api_key") apiKey: String = Constant.API_KEY): Observable<MovieResponse>
}