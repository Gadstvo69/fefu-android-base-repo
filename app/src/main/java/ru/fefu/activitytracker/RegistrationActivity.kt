package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.button.MaterialButton


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val backButton = findViewById<ImageButton>(R.id.registration_back)

        backButton.setOnClickListener{
            finish()
        }

        val sex = resources.getStringArray(R.array.sex)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_sex, sex)
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.registration_sex_edit)

        autocompleteTV.setAdapter(arrayAdapter)

        val agreementView = findViewById<TextView>(R.id.registration_agreement)
        agreementView.setMovementMethod(LinkMovementMethod.getInstance())

        val continueButton = findViewById<MaterialButton>(R.id.registration_continue)
        continueButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}