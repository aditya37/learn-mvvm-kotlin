package com.learn.learnmvvm.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.learn.learnmvvm.network.interceptor.ConnectivityInterceptor
import com.learn.learnmvvm.network.interceptor.QueryParameterInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpClient(
    connectivityInterceptor: ConnectivityInterceptor
){

    private var BASE_URL = "http://api.weatherstack.com/"

    private var retrofit : Retrofit? = null
    var HttpService: HttpServices? = null

    init {
        val LoggingIntercptor = HttpLoggingInterceptor()
        LoggingIntercptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(QueryParameterInterceptor())
            .addInterceptor(connectivityInterceptor)
            .addInterceptor(LoggingIntercptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)

        if(retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
            HttpService = retrofit!!.create(HttpServices::class.java)
        }

    }
}