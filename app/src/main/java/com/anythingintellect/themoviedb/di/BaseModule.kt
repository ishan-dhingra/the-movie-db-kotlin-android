package com.anythingintellect.themoviedb.di

import android.content.Context
import com.anythingintellect.themoviedb.network.MovieAPI
import com.anythingintellect.themoviedb.repo.MovieRepository
import com.anythingintellect.themoviedb.repo.MovieRepositoryImpl
import com.anythingintellect.themoviedb.util.ToastManager
import com.anythingintellect.themoviedb.util.Toaster
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ishan.dhingra on 06/11/17.
 */
@Module(includes = arrayOf(NetworkModule::class))
class BaseModule(val appContext: Context) {

    @Provides
    @Singleton
    fun providesMovieRepository(api: MovieAPI): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesToaster(): Toaster {
        return ToastManager(appContext)
    }

}