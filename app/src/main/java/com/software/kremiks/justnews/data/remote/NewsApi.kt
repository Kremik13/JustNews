package com.software.kremiks.justnews.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface NewsApi {



    companion object Factory {
        private const val TOKEN = "ffd0f9eabee6403c93ddca0bdd24f2c3"
        private const val BASE_URL = "https://newsapi.org/v2/"

        val service: NewsApi by lazy {
            retrofit.create(NewsApi::class.java)
        }

        private val retrofit by lazy {
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(gson)
                    .baseUrl(BASE_URL)
                    .client(okHttp)
                    .build()
        }

        private val gson by lazy {
            GsonConverterFactory.create()
        }

        private val okHttp: OkHttpClient by lazy {
            OkHttpClient.Builder()
                    .addInterceptor { authorisationInterceptor.invoke(it) }
                    .build()
        }

        private val authorisationInterceptor: ((Interceptor.Chain) -> Response) = { chain ->
            chain.proceed(
                    chain.request()
                            .newBuilder()
                            .addHeader("Authorization", TOKEN)
                            .build()
            )
        }


    }
}