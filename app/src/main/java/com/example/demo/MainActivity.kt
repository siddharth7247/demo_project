package com.example.demo

import ConstraintLayoutDemo.ConstraintLayoutDemo
import IntentDemo.LoginActivity
import ViewsDemo.DetailsActivity
import ViewsDemo.SignUp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnIntent : Button
    lateinit var btnConstaint : Button
    lateinit var btnViews : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById<Button>(R.id.intentDemo)
        btnConstaint = findViewById<Button>(R.id.constraintLayoutDemo)
        btnViews = findViewById<Button>(R.id.viewsDemo)


        btnIntent.setOnClickListener(){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        btnConstaint.setOnClickListener(){
            intent = Intent(applicationContext, ConstraintLayoutDemo::class.java)
            startActivity(intent)
        }

        btnViews.setOnClickListener(){
            intent = Intent(applicationContext,SignUp::class.java)
            startActivity(intent)
        }
    }
}

