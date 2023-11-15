package com.example.danhba

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.danhba.model.Contact


class DetailActivity: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val contactName: TextView = findViewById(R.id.textView)
        val phoneNumber: TextView = findViewById(R.id.textView3)
        val email: TextView = findViewById(R.id.textView5)
        val avatarName: TextView = findViewById(R.id.name_avt)

        val contact = intent.getParcelableExtra("contact", Contact::class.java)
        if (contact != null) {
            contactName.text = contact.name
            phoneNumber.text = contact.phone
            email.text = contact.email
            avatarName.text = contact.name.subSequence(0..0)
        }

        val backButton: ImageView = findViewById(R.id.arrow_back)
        backButton.setOnClickListener {
            finish()
        }
    }
}