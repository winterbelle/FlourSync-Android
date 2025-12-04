package com.example.floursync.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity (tableName = "User")

data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val fName: String,
    val lName: String,

    @ColumnInfo(name = "email", index = true)
    val email: String,

    @ColumnInfo(name = "username", index = true)
    val username: String,

    val password: String
)
