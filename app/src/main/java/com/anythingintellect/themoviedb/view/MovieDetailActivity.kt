package com.anythingintellect.themoviedb.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anythingintellect.themoviedb.R
import com.anythingintellect.themoviedb.databinding.ActivityMovieDetailBinding
import com.anythingintellect.themoviedb.model.Movie

class MovieDetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = Builder.getMovie(intent.extras)
        // Not using ViewModel, as this screen is not supposed to have any behaviour
        val binding = DataBindingUtil
                .setContentView<ActivityMovieDetailBinding>(this,
                        R.layout.activity_movie_detail)
        binding.movie = movie
        setTitle(movie.title)

    }

    object Builder {
        val KEY_TITLE: String = "title"
        val KEY_POSTER: String = "poster"
        val KEY_OVERVIEW: String = "overView"
        val KEY_RATING: String = "rating"

        fun getArgs(title: String, poster: String, overView: String, rating: Float): Bundle {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_OVERVIEW, overView)
            args.putString(KEY_POSTER, poster)
            args.putFloat(KEY_RATING, rating)
            return args
        }

        fun getMovie(bundle: Bundle): Movie {
            return Movie(0, bundle.getString(KEY_TITLE),
                    bundle.getString(KEY_OVERVIEW), bundle.getFloat(KEY_RATING),
                    "", bundle.getString(KEY_POSTER), "")
        }
    }
}
