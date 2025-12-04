package com.example.floursync.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

    @Query("SELECT * FROM product WHERE category = :category ORDER BY name ASC")
    suspend fun getProductsByCategory(category: String): List<Product>

    //returns a list of all the categories (DISTINCT) makes sure there are no duplicates.
    @Query("SELECT DISTINCT category FROM product")
    suspend fun getAllCategories(): List<String>

    @Query("SELECT * FROM product ORDER BY name ASC")
    suspend fun getAllProducts(): List<Product>

    @Query("SELECT COUNT(*) FROM product")
    suspend fun countProducts(): Int

}