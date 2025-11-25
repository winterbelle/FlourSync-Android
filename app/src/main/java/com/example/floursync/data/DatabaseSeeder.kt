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
            var products = listOf(
                Product(name = "Triple Decker", category = "Cakes", price = 19.99, imagePath = "cake_tripleDecker", stockQty = 12),
                Product(name = "Red Velvet", category = "Cakes", price = 19.99, imagePath = "cake_redVelvet", stockQty = 10),
                Product(name = "Carrot Cake", category = "Cakes", price = 21.99, imagePath = "cake_carrot", stockQty = 15),
                Product(name = "Angel Food", category = "Cakes", price = 16.99, imagePath = "cake_angelFood", stockQty = 7),
                Product(name = "Black Forest", category = "Cakes", price = 17.99, imagePath = "cake_blackForest", stockQty = 8),
                Product(name = "Devil's Food", category = "Cakes", price = 16.99, imagePath = "cake_devilsFood", stockQty = 8),
                Product(name = "Vanilla Buttercream", category = "Cakes", price = 19.99, imagePath = "cake_vanilla", stockQty = 5),
                Product(name = "German Chocolate", category = "Cakes", price = 19.99, imagePath = "cake_german", stockQty = 6),
                Product(name = "Tres Leches", category = "Cakes", price = 25.99, imagePath = "cake_tresLeches", stockQty = 12),
                Product(name = "Puff Pastry", category = "Pastries", price = 3.50, imagePath = "pastry_puff", stockQty = 20),
                Product(name = "Cannoli", category = "Pastries", price = 6.00, imagePath = "pastry_cannoli", stockQty = 57),
                Product(name = "Chocolate Covered Strawberries", category = "Pastries", price = 3.50, imagePath = "pastry_strawberries", stockQty = 30),
                Product(name = "Lobster Tails", category = "Pastries", price = 6.50, imagePath = "pastry_lobsterTails", stockQty = 10),
                Product(name = "Eclair", category = "Pastries", price = 4.50, imagePath = "pastry_eclair", stockQty = 12),
                Product(name = "French Macron", category = "Pastries", price = 3.69, imagePath = "pastry_frenchMacroons", stockQty = 9),
                Product(name = "Mini Cannoli", category = "Pastries", price = 3.50, imagePath = "pastry_miniCannoli", stockQty = 68),
                Product(name = "Mixed Fruit Tarts", category = "Pastries", price = 5.50, imagePath = "pastry_MFT", stockQty = 8),
                Product(name = "Strawberry Tart", category = "Pastries", price = 5.50, imagePath = "pastry_strawberryTart", stockQty = 9),
                Product(name = "Berry Tart", category = "Pastries", price = 5.50, imagePath = "pastry_berryTart", stockQty = 8),
                Product(name = "Croissant", category = "Breakfast", price = 4.29, imagePath = "breakfast_croissant", stockQty = 12),
                Product(name = "Chocolate Croissant", category = "Breakfast", price = 4.50, imagePath = "breakfast_chocoCroissant", stockQty = 5),
                Product(name = "Cinnamon Roll", category = "Breakfast", price = 4.29, imagePath = "breakfast_cinnamonRoll", stockQty = 4),
                Product(name = "Cheese Danish", category = "Breakfast", price = 4.75, imagePath = "breakfast_cheeseDanish", stockQty = 2),
                Product(name = "Apple Turnover", category = "Breakfast", price = 4.75, imagePath = "breakfast_appleTurnover", stockQty = 2),

            )
            db.ProductDao().insertAll(products)
        }
    }
}