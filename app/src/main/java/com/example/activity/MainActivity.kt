package com.example.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnNext : Button
    private lateinit var edNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext = findViewById(R.id.btn_Next)
        edNumber = findViewById(R.id.ed_Number)

        btnNext.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java).putExtra("number",edNumber.text.toString()))
        }


    }
}


