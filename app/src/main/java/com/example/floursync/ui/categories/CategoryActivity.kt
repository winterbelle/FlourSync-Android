package com.example.floursync.ui.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.lifecycleScope
import com.example.floursync.databinding.ActivityCategoriesBinding
import com.example.floursync.ui.menu.ProductsActivity
import com.example.floursync.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

       loadCategories()

    }

    private fun loadCategories() {
        val db = AppDatabase.getDatabase(this)
        val productDao = db.productDao()

        lifecycleScope.launch(Dispatchers.IO) {
            val categories = productDao.getAllCategories()

            withContext(Dispatchers.Main) {
                setupRecycler(categories)
            }
        }
    }

    private fun setupRecycler(categories: List<String>) {
        val adapter = CategoryAdapter(categories) { category ->

            val intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("category", category)
            startActivity(intent)
        }

        binding.recyclerCategories.layoutManager = LinearLayoutManager(this)
        binding.recyclerCategories.adapter = adapter
    }

}