package com.example.activity

import android.Manifest
import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1
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
        val permission = Manifest.permission.CALL_PHONE
        (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)



    }
}


