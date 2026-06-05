package com.example.data.dataSource.remote

import com.example.data.entities.workouts.WorkoutResp
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/workouts")
    suspend fun getWorkouts(): Response<WorkoutResp>
}