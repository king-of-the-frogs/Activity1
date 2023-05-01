package com.example.activity.di

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.activity.R
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {
    @Inject
    lateinit var telephonyManager: TelephonyManager

    private lateinit var textNumber: TextView
    private lateinit var okButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val appComponent = DaggerAppComponent.factory().create(applicationContext)
        appComponent.inject(this)

        textNumber = findViewById(R.id.tv_Number)
        okButton = findViewById(R.id.okButton)

        val number = intent.getStringExtra("number")
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$number")

        textNumber.text = "" + number

        okButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



