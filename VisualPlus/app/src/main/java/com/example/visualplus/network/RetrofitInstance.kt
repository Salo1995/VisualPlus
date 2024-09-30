package com.example.visualplus.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://firebasestorage.googleapis.com/v0/b/tu-proyecto.appspot.com/o/"

    val api: RutinasApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RutinasApi::class.java)
    }
}
