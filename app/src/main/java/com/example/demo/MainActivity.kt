package com.example.demo

import ConstraintLayoutDemo.ConstraintLayoutDemo
import DrawableDemo.DrawableDemo
import IntentDemo.LoginActivity
import ViewsDemo.DetailsActivity
import ViewsDemo.SignUp
import ViewsDemo.ViewsDemoActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {

    lateinit var btnIntent : Button
    lateinit var btnConstaint : Button
    lateinit var btnViews : Button
    lateinit var btnDrawable : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        btnIntent = findViewById<Button>(R.id.intentDemo)
        btnConstaint = findViewById<Button>(R.id.constraintLayoutDemo)
        btnViews = findViewById<Button>(R.id.viewsDemo)
        btnDrawable = findViewById<Button>(R.id.drawableDemo)


        btnIntent.setOnClickListener(){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        btnConstaint.setOnClickListener(){
            intent = Intent(applicationContext, ConstraintLayoutDemo::class.java)
            startActivity(intent)
        }

        btnViews.setOnClickListener(){
            intent = Intent(applicationContext,ViewsDemoActivity::class.java)
            startActivity(intent)
        }
        btnDrawable.setOnClickListener(){
            intent = Intent(applicationContext,DrawableDemo::class.java)
            startActivity(intent)
        }
    }
}

