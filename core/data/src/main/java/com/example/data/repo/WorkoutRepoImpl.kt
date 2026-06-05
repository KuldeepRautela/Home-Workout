package com.example.data.repo

import com.example.domain.models.WorkoutResponse
import com.example.domain.repository.WorkoutRepository

class WorkoutRepoImpl : WorkoutRepository {
    override suspend fun allWorkouts(): List<WorkoutResponse> {

    }
}