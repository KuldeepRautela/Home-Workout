package com.example.domain.models

data class WorkoutResponse(
    val id: Long,
    val title: String,
    val description: String,
    val type: String,
    val difficulty: String,
    val durationInMinutes: Int,
    val caloriesBurned: Int,
    val totalExercises: Int,
    val thumbnailName: String,
)