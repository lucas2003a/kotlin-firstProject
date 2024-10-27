package com.example.kotlinfirst.todoApp.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirst.R

class CategoriesAdapter(private val context : Context, private val categories : List<TaskCategory>) : RecyclerView.Adapter<CategoriesViewHolder>() {

    /*Return an instance of ViewHolder (items of recycler view)*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false);
        return CategoriesViewHolder(view, context);
    }

    /*Return list size*/
    override fun getItemCount(): Int {
        return categories.size;
    }

    /*Bind data to ViewHolder(render the items)*/
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position]);
    }
}