package com.example.neuroanswers.data.network

import com.example.neuroanswers.data.MainAPI
import com.example.neuroanswers.data.StorageInterface
import com.example.neuroanswers.data.models.GPTRequestBody
import com.example.neuroanswers.data.models.GPTResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StorageImpl{
    companion object:StorageInterface {
        val client = Retrofit.Builder()
            .baseUrl("https://russiannlp.github.io/rugpt-demo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val mainAPI: MainAPI = client.create(MainAPI::class.java)

        override suspend fun getResponse(request: String):String {
           return mainAPI.getText(GPTRequestBody(request))
        }
    }
}