package com.example.visualplus.network

import retrofit2.http.GET
import com.example.visualplus.firebase.Rutina

interface RutinasApi {
    @GET("rutinas.json?alt=media")
    suspend fun getRutinas(): List<Rutina>
}
