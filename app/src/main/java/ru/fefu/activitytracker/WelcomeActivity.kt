package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        val regButton = findViewById<Button>(R.id.welcome_registration)
        val loginButton = findViewById<Button>(R.id.welcome_login)

        regButton.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}