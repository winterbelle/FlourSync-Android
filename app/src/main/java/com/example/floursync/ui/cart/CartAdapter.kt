package com.example.floursync.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floursync.data.CartManager
import com.example.floursync.data.Product
import com.example.floursync.databinding.CartItemBinding

class CartAdapter(private val listener: CartListener) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>()
 {

    private var items = listOf<Product>()

    fun submitList(list: List<Product>) {
        items = list
        notifyDataSetChanged()
    }

    inner class CartViewHolder(val binding: CartItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CartItemBinding.inflate(inflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = items[position]

        holder.binding.tvCartName.text = product.name
        holder.binding.tvCartPrice.text = "$${product.price}"

        holder.binding.btnRemove.setOnClickListener {
            CartManager.removeItem(product)
            submitList(CartManager.items.toList())
            listener.onCartUpdated()
        }
    }
    interface CartListener {
        fun onCartUpdated()
    }


    override fun getItemCount() = items.size
}