package com.example.kotlinfirst.todoApp.tasks

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirst.R
import com.example.kotlinfirst.todoApp.categories.TaskCategory

class TasksAdapter(private val context : Context, private val tasks : List<Task>) : RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_tasks, parent, false);
        return TaskViewHolder(context, view);
    }

    override fun getItemCount(): Int {
        return tasks.size;
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position]);
    }
}