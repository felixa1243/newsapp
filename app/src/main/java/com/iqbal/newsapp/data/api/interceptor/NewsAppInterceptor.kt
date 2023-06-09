package com.iqbal.newsapp.data.api.interceptor

import com.iqbal.newsapp.Config
import okhttp3.Interceptor
import okhttp3.Response

class NewsAppInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()
        val url = originalHttpUrl.newBuilder().addQueryParameter("apikey",Config.ApiKey).build()
        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}