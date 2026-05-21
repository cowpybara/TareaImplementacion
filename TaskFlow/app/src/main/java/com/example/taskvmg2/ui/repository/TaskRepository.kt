package com.example.taskvmg2.ui.repository

import com.example.taskvmg2.ui.model.Task
import com.example.taskvmg2.ui.screen.TaskDetailScreen

class TaskRepository {
    private val tasks = mutableListOf(
        Task(1, "Entregar proyecto de POO", priority = "Alta"),
        Task(2, "Estudiar para el parcial", priority = "Alta", completed = true),
        Task(3, "Leer artículo de Compose", priority = "Media"),
        Task(4, "Hacer ejercicio", priority = "Baja"),
        Task(5, "Llamar a mamá", priority = "Baja")
    )

    fun getTasks(): List<Task> = tasks.toList()

    fun addTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = task // Edita
        } else {
            tasks.add(task) // Crea
        }
    }

    fun getTaskId(id: Int): Task? = tasks.find { it.id == id }

    fun removeTask(task: Task) {
        tasks.removeAll { it.id == task.id }
    }

    fun toggleTask(task: Task) {
        val index = tasks.indexOf(task)
        if (index != -1) {
            tasks[index] = task.copy(completed = !task.completed)
        }
    }
}