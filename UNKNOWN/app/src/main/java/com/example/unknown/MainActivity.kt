package com.example.unknown

import PostingActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val signInTextView: TextView = findViewById(R.id.sign_in_text)
        val emailEditText: EditText = findViewById(R.id.email_edit_text)
        val passwordEditText: EditText = findViewById(R.id.password_edit_text)
        val signInButton: Button = findViewById(R.id.sign_in_button)
        signInButton.setOnClickListener {
            val intent1 = Intent (this, PostingActivity::class.java)
            startActivity(intent1)
        }

        val dontHaveAccountTextView: TextView = findViewById(R.id.dont_have_account_text)
        val signUpButton: Button = findViewById(R.id.sign_up_button)




        // Set up listeners or actions if needed
    }
}
