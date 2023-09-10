package com.example.nxtpetask.network


import com.example.nxtpetask.model.MandateDetails
import com.example.nxtpetask.model.PageDetails
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface Api {
  @GET("mandate/res.json")
  suspend fun getDetails():PageDetails
}