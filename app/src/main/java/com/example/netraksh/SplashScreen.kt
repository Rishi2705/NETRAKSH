package com.example.netraksh

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.netraksh.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.splashscr.alpha= 0f
        binding.splashscr.animate().setDuration(2000).alpha(1f).withEndAction{
            startActivity(Intent(this,SignIn::class.java))
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in,androidx.appcompat.R.anim.abc_fade_out)
            finish()
        }
    }
}