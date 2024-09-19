package com.example.netraksh

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.netraksh.databinding.ActivityProfileScreenBinding

class ProfileScreen : AppCompatActivity() {
    private lateinit var binding: ActivityProfileScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.contBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}