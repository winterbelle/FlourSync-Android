package com.example.floursync.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    //creates new user
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(user: User)

    // Check if username already exists
    @Query("SELECT * FROM user WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?

    // Check if email already exists
    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM user WHERE username = :username AND password = :password LIMIT 1")
    suspend fun loginByUsername(username: String, password: String): User?
}