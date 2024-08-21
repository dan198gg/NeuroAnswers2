package com.example.neuroanswers.data

import com.example.neuroanswers.data.models.GPTResponseBody

interface StorageInterface {


    suspend fun getResponse(request: String):String
}