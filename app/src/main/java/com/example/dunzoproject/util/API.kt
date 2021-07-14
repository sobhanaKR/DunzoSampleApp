package com.example.dunzoproject.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class API {
    companion object {

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com")
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun getClient(): OkHttpClient? {
            val httpClient = OkHttpClient.Builder()
            httpClient.readTimeout(60, TimeUnit.SECONDS)
            httpClient.connectTimeout(60, TimeUnit.SECONDS)
            httpClient.addInterceptor { chain: Interceptor.Chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            return buildClient(httpClient)
        }


        private fun buildClient(httpClient: OkHttpClient.Builder): OkHttpClient? {
            return httpClient.build()
        }
    }
}