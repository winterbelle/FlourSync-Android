package com.example.floursync

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.floursync.ui.login.SignupLogin
import com.example.floursync.databinding.ActivityMainBinding
import com.example.floursync.data.DatabaseSeeder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DatabaseSeeder.seedDatabase(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate to the Login/Signup screen
        val intent = Intent(this, SignupLogin::class.java)
        startActivity(intent)
        finish()
    }
}