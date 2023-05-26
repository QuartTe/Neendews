package com.example.project.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.CategoryItemBinding

class CategoryAdapter(val getCategoryName: (String) -> Unit): RecyclerView.Adapter<CategoryAdapter.Holder>() {

    var categoryList = ArrayList<String>()


    inner class Holder(view: View):RecyclerView.ViewHolder(view){
        val binding = CategoryItemBinding.bind(view)

        fun bind(category: String){
            binding.categoryName.text = category
            Log.d("HERE", category)

            binding.root.setOnClickListener{
                getCategoryName(categoryList[adapterPosition])
            }
        }

    }

    fun setList(categories: List<String>){
        Log.d("HERE", categories[3])
        categoryList.clear()
        categoryList.addAll(categories)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        Log.d("HERE", "getItemCount: ")
        return categoryList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(categoryList[position])
        Log.d("HERE", holder.toString())
    }

}