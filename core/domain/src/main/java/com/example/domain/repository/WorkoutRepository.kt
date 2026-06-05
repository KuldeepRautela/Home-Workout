package com.example.domain.repository

import com.example.domain.models.WorkoutResponse

interface WorkoutRepository {
    suspend fun allWorkouts():List<WorkoutResponse>
}