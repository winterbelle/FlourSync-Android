package com.example.floursync.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

    @Query("SELECT * FROM product WHERE category = :category")
    suspend fun getProductByCategory(category: String): List<Product>

    @Query("SELECT DISTINCT category FROM product")
    suspend fun getAllCategories(): List<String>
}