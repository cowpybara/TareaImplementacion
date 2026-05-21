package com.example.taskvmg2.repository

import com.example.taskvmg2.model.Task

class TaskRepository {
    private val tasks = mutableListOf(
        Task(1, "Entregar proyecto de POO", "Subir al aula virtual", priority = 1),
        Task(2, "Estudiar para el parcial", "Repasar capítulos 3 y 4", priority = 1, completed = false),
        Task(3, "Leer artículo de Compose", "Navigation y StateFlow", priority = 2),
        Task(4, "Hacer ejercicio", "30 minutos cardio", priority = 3, completed = true),
        Task(5, "Llamar a mamá", "", priority = 3)
    )

    fun getTasks(): List<Task> =
        tasks.sortedWith(compareBy({ it.priority }, { it.completed }))

    fun addTask(task: Task) = tasks.add(task)

    fun getTaskById(id: Int): Task? = tasks.find { it.id == id }

    fun updateTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) tasks[index] = task
    }

    fun removeTask(task: Task) = tasks.remove(task)

    fun toggleTask(task: Task) {
        val index = tasks.indexOf(task)
        if (index != -1) tasks[index] = task.copy(completed = !task.completed)
    }
}
