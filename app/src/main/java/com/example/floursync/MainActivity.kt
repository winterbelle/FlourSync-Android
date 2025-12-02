package com.example.floursync

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.floursync.databinding.ActivityMainBinding
import com.example.floursync.ui.checkout.CheckoutActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navigate to the Category screen
        val intent = Intent(this, CheckoutActivity::class.java)
        startActivity(intent)

        finish()
    }
}
