package com.example.neuroanswers

import retrofit.http.Body
import retrofit.http.Header
import retrofit.http.Headers
import retrofit.http.POST

interface MainAPI {
    @Headers("Content-Type:application/json",
            "")
    @POST("/")
    fun getText(@Body requestBody:GPTRequestBody):GPTResponseBody
}