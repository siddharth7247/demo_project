package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button1)

        var myToast = Toast.makeText(applicationContext,"Activity created",Toast.LENGTH_LONG)
        myToast.show()

        button.setOnClickListener(){
            intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

