package com.example.data.entities.workouts

data class Data(
    val caloriesBurned: Int,
    val description: String,
    val difficulty: String,
    val durationInMinutes: Int,
    val id: Int,
    val thumbnailName: String,
    val title: String,
    val totalExercises: Int,
    val type: String
)