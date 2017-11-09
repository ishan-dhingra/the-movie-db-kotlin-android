package com.anythingintellect.themoviedb.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import com.anythingintellect.themoviedb.R
import com.anythingintellect.themoviedb.model.Movie
import com.anythingintellect.themoviedb.model.MovieResponse
import com.anythingintellect.themoviedb.repo.MovieRepository
import com.anythingintellect.themoviedb.util.Toaster
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

/**
 * Created by ishan.dhingra on 07/11/17.
 */
class MovieListViewModel @Inject constructor(val repository: MovieRepository, val toaster: Toaster): BaseViewModel() {

    val movies = ObservableArrayList<Movie>()
    val showError = ObservableField<Boolean>(false)
    val showLoading = ObservableField<Boolean>(false)
    var date: Date? = null
    private var page: Int = 1
    private var subscription: Disposable? = null
    private var totalPages = -1

    // Returns if request was accepted
    fun loadMovies(selectedDate: Date? = date){
        if (date != selectedDate) {
            // Requested with new date, so start from page 1
            page = 1
            totalPages = -1
            movies.clear()
            subscription?.dispose()
            showLoading.set(false)
            this.date = selectedDate
        }
        if (showLoading.get() || totalPages == page) {
            return
        }
        showLoading.set(true)
        showError.set(false)
        subscription = repository.getMovies(page, date!!).subscribe({
            response: MovieResponse ->
            response.results?.let {
                movies.addAll(response.results)
                page = response.page!! + 1
                totalPages = response.totalPages!!
            }

        },handleError,{
            showLoading.set(false)
        })
    }

    var handleError = fun (t: Throwable) {
        t.printStackTrace()
        showLoading.set(false)
        if (movies.size == 0) {
            showError.set(true)
        } else {
            toaster.showLong(R.string.msg_unable_to_load)
        }
    }

    override fun dispose() {
        subscription?.dispose()
        showLoading.set(false)
        showError.set(false)
    }

}