package com.example.floursync.ui.menu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.floursync.data.AppDatabase
import com.example.floursync.data.Product
import com.example.floursync.ui.cart.CartFragment
import com.example.floursync.databinding.ActivityProductsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding for activity_products.xml
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        val category = intent.getStringExtra("category") ?: ""

        setupRecyclerView()
        loadProductsFromDatabase(category)
        loadCartFragment()

        binding.btnOpenCart.setOnClickListener {
            toggleCart()
        }
    }

    private fun toggleCart() {
        if (binding.cartFragmentContainer.visibility == View.GONE) {
            binding.cartFragmentContainer.visibility = View.VISIBLE

            val fragment = supportFragmentManager.findFragmentById(binding.cartFragmentContainer.id)
            if (fragment is CartFragment) fragment.refreshCart()

        } else {
            binding.cartFragmentContainer.visibility = View.GONE
        }
    }

    private fun loadCartFragment() {
        val fragment = CartFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.cartFragmentContainer.id, fragment)
            .commit()
    }

    private fun setupRecyclerView() {
        adapter = ProductAdapter(this, emptyList()) { product ->
            // product click if needed
        }

        binding.rvProducts.layoutManager = GridLayoutManager(this, 2)
        binding.rvProducts.adapter = adapter
    }

    private fun loadProductsFromDatabase(category: String) {
        val db = AppDatabase.getDatabase(this)
        val productDao = db.productDao()

        CoroutineScope(Dispatchers.IO).launch {
            val products: List<Product> =
                if (category.isNotEmpty()) {
                    productDao.getProductsByCategory(category)
                } else {
                    productDao.getAllProducts()
                }

            withContext(Dispatchers.Main) {
                adapter.updateProducts(products)
            }
        }
    }
}