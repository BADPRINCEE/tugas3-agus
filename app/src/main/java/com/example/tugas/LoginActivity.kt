package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas.databinding.ActivityLoginBinding


@Suppress("NAME_SHADOWING")
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonLogin.setOnClickListener{

            val email : String = binding.editTextTextEmailAddress.text.toString().trim()
            binding.editTextTextPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.editTextTextEmailAddress.error = "Input Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editTextTextEmailAddress.error = "Invalid Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }


            binding.textRegister.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                binding.buttonPw.setOnClickListener {
                    val intent = Intent(this, PwActivity::class.java)
                    startActivity(intent) }
            }
        }
    }}