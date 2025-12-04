package com.example.floursync.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

object DatabaseSeeder {

    fun seedDatabase(context: Context) {
        val db = AppDatabase.getDatabase(context)
        CoroutineScope(Dispatchers.IO).launch {
            //insert products
            val count = db.productDao().countProducts()

            if (count == 0) {
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
                        category = "Cookies",
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
                        category = "Bread",
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

                db.productDao().insertAll(products)
            }
        }
    }
}