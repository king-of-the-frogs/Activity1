package com.example.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    private lateinit var textNumber : TextView
    private lateinit var okButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textNumber = findViewById(R.id.tv_Number)
        okButton = findViewById(R.id.okButton)

        val number = intent.getStringExtra("number")
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:" + number)

        textNumber.text = "" + number

        okButton.setOnClickListener{
            startActivity(intent)
        }
    }
}



