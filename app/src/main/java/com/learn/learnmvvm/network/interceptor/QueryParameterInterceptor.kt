package com.learn.learnmvvm.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterInterceptor : Interceptor{

    private var ACCESS_KEY = "73503e07fe0f981549104bd8db0ae8b0"

    override fun intercept(chain: Interceptor.Chain): Response {

        val queryParameter = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("access_key",ACCESS_KEY)
            .build()
        val request = chain.request()
            .newBuilder()
            .url(queryParameter)
            .build()
        return chain.proceed(request)
    }

}