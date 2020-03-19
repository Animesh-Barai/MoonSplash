package com.hyejeanmoon.wallpaperbyunsplash.data.api.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * ApiInterceptor
 *
 * It's a Interceptor for Retrofit, in order to push [client-id] in header to the Unsplash server.
 */
class ApiInterceptor(private val clientId: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Client-ID $clientId")
            .build()

        Log.d("$TAG RequestBody: ", request.body().toString())

        return chain.proceed(request)
    }

    companion object {
        const val TAG = "ApiInterceptor"
    }
}