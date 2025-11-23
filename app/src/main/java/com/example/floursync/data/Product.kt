package com.example.floursync.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")

data class Product (
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val imagePath: String,
    val stockQty: Int
)
