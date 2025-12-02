package com.example.floursync.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
            product.imagePath,   // e.g. "croissant"
            "drawable",
            context.packageName
        )

        if (resId != 0) {
            holder.binding.imgProduct.setImageResource(resId)
        } else {
            holder.binding.imgProduct.setImageResource(android.R.drawable.ic_menu_report_image)
        }

        holder.binding.btnAddToCart.setOnClickListener {
            onAddToCartClick(product)
        }
    }

    override fun getItemCount(): Int = productList.size

    fun setData(newList: List<Product>) {
        productList = newList
        notifyDataSetChanged()
    }
}
