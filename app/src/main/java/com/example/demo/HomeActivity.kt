package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        Log.d("onCreate","OnCreate Called?")

        var txtuname = findViewById<TextView>(R.id.txtuname)
        var txtpass = findViewById<TextView>(R.id.txtpass)

        var bundle : Bundle? = intent.extras
        var username = bundle?.get("username")
        var password = bundle?.get("password")

        txtuname.text = username.toString()
        txtpass.text = password.toString()

    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStart","OnStart Called! in Home Activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume","OnResume Called! in Home Activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPause","OnPause Called! in Home Activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","OnStop Called! in Home Activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy","OnDestroy Called! in Home Activity")
    }
}