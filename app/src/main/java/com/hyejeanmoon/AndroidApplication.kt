package com.hyejeanmoon

import com.hyejeanmoon.wallpaperbyunsplash.DI.createApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * AndroidApplication
 *
 * It's a custom Application.
 */
class AndroidApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return createApplicationComponent()
    }
}