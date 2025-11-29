package com.example.floursync.data

object SignupLoginDao {

    private val userDatabase = mutableMapOf<String, UserInfo>()

    fun addUser(user: UserInfo): Boolean {
        if (userDatabase.containsKey(user.username)) return false
        userDatabase[user.username] = user
        return true
    }

    fun getUser(username: String): UserInfo? {
        return userDatabase[username]
    }
}
