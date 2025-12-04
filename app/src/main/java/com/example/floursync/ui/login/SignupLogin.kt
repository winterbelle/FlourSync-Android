package com.example.floursync.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.floursync.data.AppDatabase
import com.example.floursync.data.User
import com.example.floursync.databinding.ActivitySignupLoginBinding
import com.example.floursync.ui.categories.CategoryActivity
import com.example.floursync.ui.menu.ProductsActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupLogin : AppCompatActivity() {

    private lateinit var binding: ActivitySignupLoginBinding

    private val userDao = AppDatabase.getDatabase(this).userDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLogin()
        setupSignup()

    }

    private fun setupLogin() {
        binding.btnLogin.setOnClickListener {

            val username = binding.etLoginUsername.text.toString()
            val password = binding.etLoginPassword.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                val user = userDao.loginByUsername(username, password)

                withContext(Dispatchers.Main) {
                    when (user) {
                        null -> {
                            Toast.makeText(this@SignupLogin, "Invalid login", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this@SignupLogin, "Login Successful!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@SignupLogin, CategoryActivity::class.java))
                            finish()
                        }
                    }
                }
            }
        }
    }

    private fun clearSignupFields() {
        binding.etSignupFirstName.text.clear()
        binding.etSignupLastName.text.clear()
        binding.etSignupEmail.text.clear()
        binding.etSignupUserName.text.clear()
        binding.etSignupPassword.text.clear()
    }

    private fun setupSignup() {
        binding.btnSignup.setOnClickListener {

            val first = binding.etSignupFirstName.text.toString()
            val last = binding.etSignupLastName.text.toString()
            val email = binding.etSignupEmail.text.toString()
            val username = binding.etSignupUserName.text.toString()
            val password = binding.etSignupPassword.text.toString()

            val newUser = User(
                fName = first,
                lName = last,
                email = email,
                username = username,
                password = password
            )

            lifecycleScope.launch(Dispatchers.IO) {

                // Check email + username availability
                val existingEmail = userDao.getUserByEmail(email)
                val existingUsername = userDao.getUserByUsername(username)

                withContext(Dispatchers.Main) {

                    when {
                        existingEmail != null -> {
                            Toast.makeText(this@SignupLogin, "Email already registered!", Toast.LENGTH_SHORT).show()
                        }
                        existingUsername != null -> {
                            Toast.makeText(this@SignupLogin, "Username already taken!", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            lifecycleScope.launch(Dispatchers.IO) {
                                userDao.registerUser(newUser)

                                withContext(Dispatchers.Main) {
                                    Toast.makeText(this@SignupLogin, "Account Created!", Toast.LENGTH_SHORT).show()
                                }

                                clearSignupFields()
                            }
                        }
                    }
                }
            }
        }
    }
}
