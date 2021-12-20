package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.button.MaterialButton
import ru.fefu.activitytracker.activitytracking.activity.ActivityTrackingActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val backButton = findViewById<ImageButton>(R.id.login_back)
        val continueButton = findViewById<MaterialButton>(R.id.login_continue)

        backButton.setOnClickListener{
            finish()
        }

        continueButton.setOnClickListener{
            val intent = Intent(this, ActivityTrackingActivity::class.java)
            startActivity(intent)
        }
    }
}