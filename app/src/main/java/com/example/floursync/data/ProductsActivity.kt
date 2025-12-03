package com.example.floursync.data

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.floursync.R
import com.example.floursync.adapter.ProductAdapter
import com.example.floursync.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding for activity_products.xml
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenCart.setOnClickListener {
            toggleCart()
        }


        setupRecyclerView()
        loadCartFragment()

    }

    private fun toggleCart() {
        if (binding.cartFragmentContainer.visibility == View.GONE) {
            binding.cartFragmentContainer.visibility = View.VISIBLE

            val fragment = supportFragmentManager.findFragmentById(R.id.cartFragmentContainer)
            if (fragment is CartFragment) {
                fragment.refreshCart()
            }


        } else {
            binding.cartFragmentContainer.visibility = View.GONE
        }
    }


    private fun loadCartFragment() {
        val fragment = CartFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.cartFragmentContainer, fragment)
            .commit()
    }


    private fun setupRecyclerView() {
        val products = listOf(
            Product(
                name = "Baguettes",
                category = "Bread",
                price = 4.99,
                imagePath = "baguettes",
                stockQty = 10
            ),
            Product(
                name = "Big Cookie",
                category = "Cookie",
                price = 2.49,
                imagePath = "bigcookie",
                stockQty = 20
            ),
            Product(
                name = "3\" Cake",
                category = "Cake",
                price = 9.99,
                imagePath = "cake3inch",
                stockQty = 8
            ),
            Product(
                name = "4\" Cake",
                category = "Cake",
                price = 12.99,
                imagePath = "cake4inch",
                stockQty = 6
            ),
            Product(
                name = "7\" Cake",
                category = "Cake",
                price = 19.99,
                imagePath = "cake7inch",
                stockQty = 4
            ),
            Product(
                name = "8\" Cake",
                category = "Cake",
                price = 24.99,
                imagePath = "cake8inch",
                stockQty = 3
            ),
            Product(
                name = "Challah Bread",
                category = "Bread",
                price = 6.49,
                imagePath = "challahbread",
                stockQty = 5
            ),
            Product(
                name = "Cookies by the Pound",
                category = "Cookies",
                price = 14.99,
                imagePath = "cookiesbythepound",
                stockQty = 7
            ),
            Product(
                name = "Mini Cupcakes",
                category = "Cupcakes",
                price = 11.99,
                imagePath = "minicupcakes",
                stockQty = 12
            ),
            Product(
                name = "Mini Pastries",
                category = "Pastries",
                price = 13.99,
                imagePath = "minipastries",
                stockQty = 9
            ),
            Product(
                name = "Muffins",
                category = "Muffins",
                price = 8.99,
                imagePath = "muffins",
                stockQty = 15
            ),
            Product(
                name = "Semolina Roll",
                category = "Bread",
                price = 3.49,
                imagePath = "semolinaroll",
                stockQty = 18
            )
        )

        adapter = ProductAdapter(this, products) { product ->
        }

        binding.rvProducts.layoutManager = GridLayoutManager(this, 2)
        binding.rvProducts.adapter = adapter



    }

}