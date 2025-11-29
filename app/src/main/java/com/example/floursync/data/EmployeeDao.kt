package com.example.floursync.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDao {
    // this tells room to insert an employee into the DB and if the id already exist in the DB then
    // replace instead of crashing.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend means it must run in the background.
    //the function takes a list of Employee objects and inserts them into the employees table
    suspend fun insertAll(employees: List<Employee>)

    // this is the query that will return if the employeeid exist in the table then they will be
    // able to login
    @Query("SELECT * FROM employees WHERE id = :employeeId and pin = :pin")
    suspend fun login(employeeId: Int, pin: String): Employee?
}

data class UserInfo(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val email: String
)