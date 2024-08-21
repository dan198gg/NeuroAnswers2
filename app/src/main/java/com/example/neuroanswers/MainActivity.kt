package com.example.neuroanswers

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.neuroanswers.data.models.GPTRequestBody
import com.example.neuroanswers.data.models.GPTResponseBody
import com.example.neuroanswers.data.network.StorageImpl
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    var textRequest by
        mutableStateOf("бубу")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


           CoroutineScope(Dispatchers.Default).launch {
                val response:GPTResponseBody= GPTResponseBody(StorageImpl.getResponse(Gson().toJson(GPTRequestBody(textRequest))))
                Log.i("RESP",response.predictions)
            }

        setContent {

            var textresponse by remember {
                mutableStateOf("")
            }


            Column(Modifier.padding(30.dp)) {
                TextField(value = textRequest, onValueChange = {textRequest=it})

            }
        }
    }
}

