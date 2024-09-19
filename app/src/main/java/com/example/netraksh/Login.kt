package com.example.netraksh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.netraksh.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        auth = Firebase.auth
        binding.signupTxt.setOnClickListener {
            startActivity(Intent(this,SignIn::class.java))
        }
        binding.contBtn.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPasswd.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Hello", "signInWithEmail:success")
                        val user = auth.currentUser
                        Toast.makeText(baseContext,"Logged In Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,ProfileScreen::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Bye", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Logged In Failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }
}