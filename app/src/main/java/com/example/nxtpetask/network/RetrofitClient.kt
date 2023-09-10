package com.example.nxtpetask.network


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private val client = OkHttpClient.Builder().build()
    fun getInstance():Retrofit=
            Retrofit.Builder()
            .baseUrl("https://apptestsoko.s3.ap-south-1.amazonaws.com/api/")
                .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

    fun init(): Api
    {
        return getInstance().create(Api::class.java)
    }
}