package com.example.floursync.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.floursync.databinding.ActivityCheckoutBinding
import com.example.floursync.ui.confirmation.OrderConfirmationActivity

class CheckoutActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding

    //temp total replacing with real total after all is connected.
    private var orderTotal = 18.75

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        val total = intent.getDoubleExtra("total", 0.0)
        binding.tvOrderTotal.text = "Total: $${"%.2f".format(total)}"

        //handle placing order
        binding.btnPlaceOrder.setOnClickListener {
            val paymentMethod = when (binding.rgPayment.checkedRadioButtonId) {
                binding.rbCard.id -> "Card"
                binding.rbCash.id -> "Pay at Pickup"
                else -> "Card"
            }

            Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT ).show()

            //redirect to confirmation screen
            val intent = Intent(this, OrderConfirmationActivity::class.java)
            intent.putExtra("paymentMethod", paymentMethod)
            intent.putExtra("total", orderTotal)
            startActivity(intent)

            finish()
        }

    }
}