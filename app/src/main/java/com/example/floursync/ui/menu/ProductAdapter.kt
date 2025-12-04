package com.example.floursync.ui.menu

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.floursync.data.CartManager
import com.example.floursync.data.Product
import com.example.floursync.databinding.ItemProductBinding

class ProductAdapter(
    private val context: Context,
    private var productList: List<Product>,
    private val onAddToCartClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.binding.tvProductName.text = product.name
        holder.binding.tvProductPrice.text = "Price: $${product.price}"
        holder.binding.tvProductCategory.text = "Category: ${product.category}"
        holder.binding.tvProductStock.text = "Stock: ${product.stockQty}"

        val resId = context.resources.getIdentifier(
            product.imagePath,
            "drawable",
            context.packageName
        )

        if (resId != 0) {
            holder.binding.imgProduct.setImageResource(resId)
        } else {
            holder.binding.imgProduct.setImageResource(R.drawable.ic_menu_report_image)
        }

        holder.binding.btnAddToCart.setOnClickListener {
            CartManager.addItem(product)
            Toast.makeText(
                holder.itemView.context,
                "${product.name} added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int = productList.size

    fun updateProducts(newProducts: List<Product>) {
        productList = newProducts
        notifyDataSetChanged()
    }
}

