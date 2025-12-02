package com.example.floursync.ui.confirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.floursync.databinding.ActivityOrderConfirmationBinding
import com.example.floursync.ui.categories.CategoryActivity

class OrderConfirmationActivity: AppCompatActivity() {
    private lateinit var binding: ActivityOrderConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paymentMethod = intent.getStringExtra("paymentMethod")
        val total = intent.getDoubleExtra("total", 0.0)

        val priceText = if (paymentMethod == "Pay at Pickup") {
            "Total Due at Pickup $${String.format("%.2f", total)}"
        } else {
            "Total Paid: $${String.format("%.2f", total)}"
        }

        binding.tvOrderDetails.text = """
            Payment: $paymentMethod
            $priceText
        """.trimIndent()

        binding.btnNewOrder.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)
            finish()
        }
    }
}