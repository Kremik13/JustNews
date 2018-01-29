package com.software.kremiks.justnews.data.remote

import com.software.kremiks.justnews.data.ArticlesResponse
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getTopNews(
            @Query("country") country: String = "us"
    ): Single<ArticlesResponse>

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
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                    .addInterceptor { authorisationInterceptor.invoke(it) }
                    .addInterceptor(interceptor)
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