package com.example.activity.di

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.activity.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var callPermission: String

    private lateinit var btnNext: Button
    private lateinit var edNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = DaggerAppComponent.factory().create(applicationContext)
        appComponent.inject(this)

        if (ContextCompat.checkSelfPermission(
                this,
                callPermission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(callPermission), 1)
        }

        this.btnNext = findViewById(R.id.btn_Next)
        edNumber = findViewById(R.id.ed_Number)

        btnNext.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java).putExtra(
                    "number",
                    edNumber.text.toString()
                )
            )
        }
    }
}