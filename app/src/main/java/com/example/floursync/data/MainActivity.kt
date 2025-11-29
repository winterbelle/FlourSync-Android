package com.example.floursync.data

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.floursync.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate to the Login/Signup screen
        val intent = Intent(this, SignupLogin::class.java)
        startActivity(intent)

        // Close MainActivity so user can't navigate back to it
        finish()
    }
}
