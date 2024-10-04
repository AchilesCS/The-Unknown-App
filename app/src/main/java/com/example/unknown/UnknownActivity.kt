package com.example.anonposts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UnknownActivity : AppCompatActivity() {

    private lateinit var editTextPost: EditText
    private lateinit var buttonPost: Button
    private lateinit var linearLayoutFirstPost: LinearLayout
    private lateinit var linearLayoutSecondPost: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPost = findViewById(R.id.editTextPost)
        buttonPost = findViewById(R.id.buttonPost)
        linearLayoutFirstPost = findViewById(R.id.linearLayoutFirstPost)
        linearLayoutSecondPost = findViewById(R.id.linearLayoutSecondPost)

        buttonPost.setOnClickListener {
            val postContent = editTextPost.text.toString().trim()

            if (postContent.isNotEmpty()) {
                // Create a new post layout
                val newPostView = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                }

                // Create the username TextView
                val usernameTextView = TextView(this).apply {
                    text = "Anonymous"
                    textSize = 16f
                    setTextColor(resources.getColor(android.R.color.black))
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(50, 5, 10, 0) // Add margin
                    }
                }

                // Create the post content TextView
                val postContentTextView = TextView(this).apply {
                    text = postContent
                    textSize = 18f
                    setTextColor(resources.getColor(android.R.color.black))
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(10, 0, 0, 0) // Add margin
                    }
                }

                // Add TextViews to the new post layout
                newPostView.addView(usernameTextView)
                newPostView.addView(postContentTextView)

                // Add the new post to the linear layout for recent posts
                linearLayoutFirstPost.addView(newPostView)

                // Clear the input field
                editTextPost.text.clear()
            }
        }
    }
}
