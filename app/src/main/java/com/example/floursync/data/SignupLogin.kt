package com.example.floursync.data;
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.floursync.databinding.ActivitySignupLoginBinding
import androidx.activity.enableEdgeToEdge

class SignupLogin : AppCompatActivity() {

    private lateinit var binding: ActivitySignupLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignupLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLogin()
        setupSignup()
    }

    private fun setupLogin() {
        binding.btnLogin.setOnClickListener {

            val username = binding.etLoginUsername.text.toString()
            val password = binding.etLoginPassword.text.toString()

            val user = SignupLoginDao.getUser(username)

            when {
                user == null ->
                    Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()

                user.password != password ->
                    Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()

                else ->
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupSignup() {
        binding.btnSignup.setOnClickListener {

            val newUser = UserInfo(
                username = binding.etSignupUserName.text.toString(),
                password = binding.etSignupPassword.text.toString(),
                firstName = binding.etSignupFirstName.text.toString(),
                lastName = binding.etSignupLastName.text.toString(),
                email = binding.etSignupEmail.text.toString()
            )

            val added = SignupLoginDao.addUser(newUser)

            if (added) {
                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Username already exists!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
