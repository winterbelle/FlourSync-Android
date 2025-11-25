package com.example.floursync.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floursync.databinding.ActivityMenuItemsBinding

class MenuItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra("category") ?: "Unknown"

        binding.tvTitleMenu.text = category
    }
}