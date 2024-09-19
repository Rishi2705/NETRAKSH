package com.example.netraksh

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.netraksh.databinding.ActivitySignInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignIn : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        auth = Firebase.auth
        binding.loginTxt.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }
        binding.contBtnRep.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPasswd.text.toString()
            if(isValidPassword(password)){
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Hello", "createUserWithEmail:success")
                            val user = auth.currentUser
                            Toast.makeText(baseContext,"Authentication Success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,Login::class.java))
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Bye", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"Password must contain one uppercase,one number and one special character",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern

        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"

        pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)

        return matcher.matches()
    }
}