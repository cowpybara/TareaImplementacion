package com.example.taskvmg2.ui.model

enum class TaskPriority { BAJA, MEDIA, ALTA }

data class Task(
    val id: Int,
    val title: String,
    val description: String = "",
    val priority: TaskPriority = TaskPriority.MEDIA,
    val completed: Boolean = false
)