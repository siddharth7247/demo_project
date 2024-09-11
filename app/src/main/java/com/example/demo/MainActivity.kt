package com.example.demo

import ConstraintLayoutDemo.ConstraintLayoutDemo
import CordinatorLayoutDemo.CordinatorLayoutDemo
import DrawableDemo.DrawableDemo
import IntentDemo.LoginActivity
import ListViewDemo.ListViewDemo
import RecyclerViewDemo.RecyclerViewDemo
import RecyclerViewDemo2.RecyclerViewDemo2
import SnackBarDemo.SnackBarDemo
import ViewPagerDemo.ViewPagerDemo
import ViewPagerDemo.racipesViewPagerDemo
import ViewsDemo.ViewsDemoActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {

    lateinit var btnIntent : Button
    lateinit var btnConstaint : Button
    lateinit var btnViews : Button
    lateinit var btnDrawable : Button
    lateinit var btnViewPager : Button
    lateinit var btnListView : Button
    lateinit var btnRecyclerView : Button
    lateinit var btnCordinator : Button
    lateinit var btnSnackbar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        btnIntent = findViewById<Button>(R.id.intentDemo)
        btnConstaint = findViewById<Button>(R.id.constraintLayoutDemo)
        btnViews = findViewById<Button>(R.id.viewsDemo)
        btnDrawable = findViewById<Button>(R.id.drawableDemo)
        btnViewPager = findViewById(R.id.viewPagerDemo)
        btnListView = findViewById(R.id.listViewDemo)
        btnRecyclerView = findViewById(R.id.recyclerViewDemo)
        btnCordinator = findViewById(R.id.cordinatorLayoutDemo)
        btnSnackbar = findViewById(R.id.snackBarDemo)


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
        btnViewPager.setOnClickListener(){
            intent = Intent(applicationContext,ViewPagerDemo::class.java)
            startActivity(intent)
        }
        btnListView.setOnClickListener(){
            intent = Intent(applicationContext,ListViewDemo::class.java)
            startActivity(intent)
        }
        btnRecyclerView.setOnClickListener(){
            intent = Intent(applicationContext,RecyclerViewDemo2::class.java)
            startActivity(intent)
        }
        btnCordinator.setOnClickListener(){
            intent = Intent(applicationContext,CordinatorLayoutDemo::class.java)
            startActivity(intent)
        }
        btnSnackbar.setOnClickListener(){
            intent = Intent(applicationContext,SnackBarDemo::class.java)
            startActivity(intent)
        }

    }
}

