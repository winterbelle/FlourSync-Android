package com.example.floursync.ui.cart

import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floursync.data.CartManager
import com.example.floursync.databinding.FragmentCartBinding
import com.example.floursync.ui.checkout.CheckoutActivity

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CartAdapter(object : CartAdapter.CartListener {
            override fun onCartUpdated() {
                refreshCart()
            }
        })

        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        // Load current cart items
        adapter.submitList(CartManager.items.toList())

        // Update total price
        binding.tvTotal.text = "Total: $${CartManager.totalPrice()}"

        // ⭐ MOVE CHECKOUT HERE ⭐
        binding.btnCheckout.setOnClickListener {

            val total = CartManager.totalPrice()

            val intent = Intent(requireContext(), CheckoutActivity::class.java)
            intent.putExtra("total", total)

            startActivity(intent)
        }
    }


    // Refresh list if fragment becomes visible again
    override fun onResume() {
        super.onResume()
        adapter.submitList(CartManager.items.toList())
        binding.tvTotal.text = "Total: $${CartManager.totalPrice()}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun refreshCart() {
        adapter.submitList(CartManager.items.toList())
        binding.tvTotal.text = "Total: $${CartManager.totalPrice()}"
    }

}