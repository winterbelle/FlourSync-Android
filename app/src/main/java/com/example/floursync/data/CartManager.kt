package com.example.floursync.data

object CartManager {
    private val _items = mutableListOf<Product>()
    val items: List<Product> get() = _items

    fun addItem(product: Product) {
        _items.add(product)
    }

    fun removeItem(product: Product) {
        _items.remove(product)
    }

    fun clear() {
        _items.clear()
    }

    fun totalPrice(): Double {
        return _items.sumOf { it.price }
    }
}
