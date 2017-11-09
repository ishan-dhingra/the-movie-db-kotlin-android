package com.anythingintellect.themoviedb.di

import com.anythingintellect.themoviedb.view.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ishan.dhingra on 06/11/17.
 */
@Component(modules = arrayOf(BaseModule::class))
@Singleton
interface AppComponent {

    fun plusContext(contextModule: ContextModule): ContextComponent

}