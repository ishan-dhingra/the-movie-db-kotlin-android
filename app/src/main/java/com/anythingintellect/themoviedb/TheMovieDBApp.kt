package com.anythingintellect.themoviedb

import android.app.Application
import com.anythingintellect.themoviedb.di.AppComponent
import com.anythingintellect.themoviedb.di.BaseModule
import com.anythingintellect.themoviedb.di.DaggerAppComponent
import com.anythingintellect.themoviedb.di.NetworkModule
import com.anythingintellect.themoviedb.util.Constant
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by ishan.dhingra on 06/11/17.
 */
class TheMovieDBApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        initAppComponent()
    }

    private fun initAppComponent() {
        this.appComponent = DaggerAppComponent
                .builder()
                .baseModule(BaseModule(this))
                .networkModule(NetworkModule(Constant.BASE_URL))
                .build();
    }


}