package ru.hmhub.agentsAndroid.data.remote

import retrofit2.http.GET

interface SampleApi {

    @GET("sample")
    suspend fun doNetworkCall()
}