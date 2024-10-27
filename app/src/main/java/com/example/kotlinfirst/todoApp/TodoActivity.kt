package com.example.kotlinfirst.todoApp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirst.R
import com.example.kotlinfirst.todoApp.categories.CategoriesAdapter
import com.example.kotlinfirst.todoApp.categories.TaskCategory
import com.example.kotlinfirst.todoApp.tasks.Task
import com.example.kotlinfirst.todoApp.tasks.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(

        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    );

    private lateinit var  tasks             : MutableList<Task>;
    private lateinit var rvCategories       : RecyclerView;
    private lateinit var rvTask             : RecyclerView;
    private lateinit var categoriesAdapter  : CategoriesAdapter;
    private lateinit var tasksAdapter       : TasksAdapter;
    private lateinit var fabAddTask         : FloatingActionButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         tasks = mutableListOf(
            Task(getString(R.string.todoAppTvBusiness), TaskCategory.Business),
            Task(getString(R.string.todoAppTvPersonal), TaskCategory.Business),
            Task(getString(R.string.todoAppTvOthers), TaskCategory.Business)
        )

        initComponents();
        intUI();
        setListeners();
    }

    private fun initComponents(){
        rvCategories    = findViewById(R.id.rvCategories);
        rvTask          = findViewById(R.id.rvTasks);
        fabAddTask      = findViewById(R.id.fabAddTask);
    }

    private fun intUI(){
        categoriesAdapter           = CategoriesAdapter(this, categories);
        tasksAdapter                = TasksAdapter(this, tasks);
        rvCategories.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false); /*Type of scroll*/
        rvTask.layoutManager        = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); /*Type of scroll*/
        rvCategories.adapter        = categoriesAdapter;
        rvTask.adapter              = tasksAdapter;
    }

    private fun setListeners(){

        fabAddTask.setOnClickListener {
            showAddTaskDialog();

        }
    }

    private fun showAddTaskDialog() {
        val dialog = Dialog(this);
        //dialog.setContentView(R.layout.dialog_add_task);
        dialog.show();
    }
}