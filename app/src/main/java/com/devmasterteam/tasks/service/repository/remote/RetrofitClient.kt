package com.devmasterteam.tasks.service.repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){
    companion object {

        private lateinit var INSTANCE: Retrofit
        // private val INSTANCE by lazy {  ?  }
        private fun getRetrofitInstance(): Retrofit {
          val httpClient = OkHttpClient.Builder().build()

            if(::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class) {
                    INSTANCE = Retrofit.Builder()
                        .baseUrl("POST http://devmasterteam.com/CursoAndroidAPI/")
                        .client(httpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTANCE
        }
    }
}