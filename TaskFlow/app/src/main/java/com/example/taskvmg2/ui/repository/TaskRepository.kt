package com.example.taskvmg2.ui.repository

import com.example.taskvmg2.ui.model.Task
import com.example.taskvmg2.ui.model.TaskPriority

class TaskRepository {
    private val tasks = mutableListOf<Task>(
        Task(1, "Estudiar POO", "Hacer el proyecto de poo", TaskPriority.ALTA, false),
        Task(2, "Avanzar proyecto de baswe de datos", "Ver contenedores docker", TaskPriority.MEDIA, true)
    )

    fun getTasks(): List<Task> = tasks

    fun getTaskId(id: Int): Task? = tasks.find { it.id == id }

    fun saveTask(task: Task) {
        val finalId = if (task.id <= 0) {
            (tasks.maxOfOrNull { it.id } ?: 0) + 1
        } else {
            task.id
        }

        val existingIndex = tasks.indexOfFirst { it.id == finalId }
        if (existingIndex != -1) {
            // Edición: Reemplazamos la tarea existente en la misma posición
            tasks[existingIndex] = task.copy(id = finalId)
        } else {
            // Creación: Insertamos la nueva tarea
            tasks.add(task.copy(id = finalId))
        }
    }

    fun removeTask(task: Task) {
        tasks.removeAll { it.id == task.id }
    }

    fun toggleTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = tasks[index].copy(completed = !tasks[index].completed)
        }
    }
}