package com.example.kotlinfirst.todoApp.tasks

import com.example.kotlinfirst.todoApp.categories.TaskCategory

data class Task(val name : String, val category : TaskCategory, var isSelected : Boolean = false) {
}