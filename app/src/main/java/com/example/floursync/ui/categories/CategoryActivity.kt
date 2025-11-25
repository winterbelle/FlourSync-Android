package com.example.floursync.ui.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floursync.databinding.ActivityCategoriesBinding
import com.example.floursync.ui.menu.MenuItemsActivity

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoriesBinding

    //fake categories until backend is connected
    private val categories = listOf(
        "Cakes",
        "Pastries",
        "Breakfast",
        "Bread",
        "Drinks"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CategoryAdapter(categories) {
            category ->

            //intent to redirect to Menu screen
            val intent = Intent(this, MenuItemsActivity::class.java)

            //passing the selected category to the next screen
            intent.putExtra("category", category)

            //open next activity
            startActivity(intent)
        }

        binding.recyclerCategories.layoutManager = LinearLayoutManager(this)
        binding.recyclerCategories.adapter = adapter
    }
}