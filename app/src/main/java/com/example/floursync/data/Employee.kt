package com.example.floursync.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//tells room to turn the sql class into a table and name it "employees"
@Entity(tableName = "employees")

data class Employee (
    @PrimaryKey val id: Int,
    val name: String,
    val pin: String
)