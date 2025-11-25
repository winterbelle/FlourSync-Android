package com.example.floursync.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")

data class Product (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    val price: Double,
    val imagePath: String,
    val stockQty: Int
)
