package com.example.kotlinfirst.todoApp.tasks

import android.content.Context
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirst.R
import org.w3c.dom.Text

class TaskViewHolder(private val context : Context, view : View) : RecyclerView.ViewHolder(view) {

    /*region : NOTE variables*/

    private val tvTask : TextView = view.findViewById(R.id.tvTask);
    private var cbTask : CheckBox = view.findViewById(R.id.cbTask);

    /*endregion : NOTE variables*/

    /*region : NOTE methods*/

    public fun render(task : Task){
        tvTask.text = task.name;
    }

    /*endregion : NOTE methods*/

}