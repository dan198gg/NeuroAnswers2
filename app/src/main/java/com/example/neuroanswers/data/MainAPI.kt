package com.example.neuroanswers.data

import com.example.neuroanswers.data.models.GPTRequestBody
import com.example.neuroanswers.data.models.GPTResponseBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MainAPI {
    @Headers("Content-Type:application/json",
        "Accept:*/*")
    @POST("/")
    suspend fun getText(@Body requestBody: GPTRequestBody): String
}