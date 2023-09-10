package com.example.nxtpetask.modules

import com.example.nxtpetask.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesClient(): OkHttpClient = OkHttpClient.Builder()
        .build()
    @Provides
    @Singleton
    fun provideRetrofit(client:OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://apptestsoko.s3.ap-south-1.amazonaws.com/api/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)
}