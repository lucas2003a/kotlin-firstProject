package com.example.kotlinfirst.todoApp.categories

sealed class TaskCategory {

    object Personal : TaskCategory();
    object Business : TaskCategory();
    object Other : TaskCategory();
}