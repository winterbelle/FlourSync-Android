package com.example.floursync.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floursync.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(val binding: ItemCategoryBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    //bind each category to the UI
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        //set category text
        holder.binding.tvCategoryName.text = category

        //handles click
        holder.binding.root.setOnClickListener {
            onClick(category)
        }
    }

    override fun getItemCount(): Int = categories.size
}