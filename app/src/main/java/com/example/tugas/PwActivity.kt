package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas.databinding.ActivityPwBinding


class PwActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPwBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityPwBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{

            val password: String = binding.editTextText.text.toString().trim()
            val repassword: String = binding.editTextText2.text.toString().trim()


            if (password.isEmpty() || password.length < 6){
                binding.editTextText.error = "password must be more than 6 characters"
                binding.editTextText.requestFocus()
                return@setOnClickListener
            }

            if (password != repassword){
                binding.editTextText2.error = "password must be match"
                binding.editTextText2.requestFocus()
                return@setOnClickListener
            }
        }

        binding.Login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}





