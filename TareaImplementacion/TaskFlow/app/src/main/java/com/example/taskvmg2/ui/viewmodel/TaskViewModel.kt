package com.example.taskvmg2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.taskvmg2.ui.repository.TaskRepository
import com.example.taskvmg2.ui.model.Task

class TaskViewModel : ViewModel() {
    private val repository = TaskRepository()

    var tasks by mutableStateOf(repository.getTasks())
        private set

    var id by mutableStateOf("")
        private set
    var title by mutableStateOf("")
        private set
    var priority by mutableStateOf("Media")
        private set
    var completed by mutableStateOf(false)
        private set

    fun onIdChange(newId: String) {
        this.id = newId
    }
    fun onTitleChange(newTitle: String) {
        this.title = newTitle
    }
    fun onCompletedChange(newCompleted: Boolean) {
        this.completed = newCompleted
    }
    fun onProrityChange(newPriority: String) {
        this.priority = newPriority
    }

    private fun refreshTask() {
        tasks = repository.getTasks()
    }

    fun loadTask(taskId: Int?) {
        if (taskId == null || taskId == -1) {
            clearForm()
        } else {
            val task = repository.getTaskId(taskId)
            task?.let {
                id = it.id.toString()
                title = it.title
                completed = it.completed
                priority = it.priority
            }
        }
    }
    fun addTask(task: Task) {
        repository.addTask(task)
        refreshTask()
    }
    fun removeTask(task: Task) {
        repository.removeTask(task)
        refreshTask()
    }
    fun toggleTask(task: Task) {
        repository.toggleTask(task)
        refreshTask()
    }
    private fun clearForm(){
        id=""
        title=""
        completed=false
        priority = "Media"
    }
}