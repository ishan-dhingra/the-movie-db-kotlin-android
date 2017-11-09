package com.anythingintellect.themoviedb.di

import com.anythingintellect.themoviedb.view.MainActivity
import dagger.Subcomponent

/**
 * Created by ishan.dhingra on 07/11/17.
 */
@ContextScope
@Subcomponent(modules = arrayOf(ContextModule::class))
interface ContextComponent {

    fun inject(mainActivity: MainActivity)

}