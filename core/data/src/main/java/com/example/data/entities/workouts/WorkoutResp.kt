package com.example.data.entities.workouts

data class WorkoutResp(
    val `data`: List<Data>,
    val error: Any,
    val message: String,
    val success: Boolean,
    val timestamp: Long
)