package com.example.taskvmg2.model

data class Task(
    val id: Int,
    val title: String,
    val description: String = "",
    val priority: Int = 2,
    val completed: Boolean = false
)
