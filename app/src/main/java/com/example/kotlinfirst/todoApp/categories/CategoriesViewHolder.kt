package com.example.kotlinfirst.todoApp.categories

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfirst.R

class CategoriesViewHolder(view : View, private val context : Context) : RecyclerView.ViewHolder(view){

    private val tvCategoryName : TextView   = view.findViewById(R.id.tvCategoryName);
    private val tvDivider : View            = view.findViewById(R.id.vDivider);

    fun render(taskCategory: TaskCategory){

        when(taskCategory){
            TaskCategory.Business ->{
                setTextCard(R.string.todoAppTvBusiness);
            }
            TaskCategory.Personal ->{
                setTextCard(R.string.todoAppTvPersonal);
            }
            TaskCategory.Other ->{
                setTextCard(R.string.todoAppTvOthers);
            }
        }
    }

    private fun setTextCard(stringIdResource : Int){
        val stringText = context.getString(stringIdResource);
        tvCategoryName.text = stringText;

        /*Color divider*/

        when(stringText){

            "Negocios" ->{
                setDividerColor(R.color.business_category_todo_app);
            };
            "Personal" -> {
                setDividerColor(R.color.personal_category_todo_app);
            };
            "Otros" ->{
                setDividerColor(R.color.other_category_todo_app);
            }
        }
    }

    private fun setDividerColor(colorIdResource : Int){

        val color = ContextCompat.getColor(tvDivider.context, colorIdResource)
        tvDivider.setBackgroundColor(color);
    }
}