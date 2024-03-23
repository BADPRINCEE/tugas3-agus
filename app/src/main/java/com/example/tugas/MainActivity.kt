package com.example.tugas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas.databinding.ActivityMainBinding

public class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cmr.setOnClickListener{

            val intentOpenWeb = Intent(Intent.ACTION_VIEW)

            intentOpenWeb.data = Uri.parse("http://google.com")

            startActivity(intentOpenWeb)

        }

        binding.buttonRegister.setOnClickListener{

            val email : String = binding.editTextTextEmailAddress.text.toString().trim()
            val password: String = binding.editTextTextPassword.text.toString().trim()
            val repassword: String = binding.editTextTextPassword2.text.toString().trim()

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

            if (password.isEmpty() || password.length < 6){
                binding.editTextTextPassword.error = "password must be more than 6 characters"
                binding.editTextTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != repassword){
                binding.editTextTextPassword2.error = "password must be match"
                binding.editTextTextPassword2.requestFocus()
                return@setOnClickListener
            }

        }

        binding.textLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }



    }
}





