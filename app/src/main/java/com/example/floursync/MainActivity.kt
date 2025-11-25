package com.example.floursync

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.floursync.databinding.ActivityMainBinding
import com.example.floursync.ui.categories.CategoryActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navigate to the Category screen
        val intent = Intent(this, CategoryActivity::class.java)
        startActivity(intent)

        finish()
    }
}
