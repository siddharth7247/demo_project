package PermissionDemo

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.demo.R


class PermissionDemo : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission_demo)
        var btnWeatherApp : Button =  findViewById(R.id.btnweatherApp)
        var btnFoodCart : Button = findViewById(R.id.btnFoodCart)

       btnWeatherApp.setOnClickListener{
           intent = Intent(applicationContext,WeatherApp::class.java)
           startActivity(intent)
       }
       btnFoodCart.setOnClickListener{

           if(ContextCompat.checkSelfPermission(this,"com.example.foodcart.permission.ACCESS") == PackageManager.PERMISSION_DENIED){
               ActivityCompat.requestPermissions(this, arrayOf("com.example.foodcart.permission.ACCESS"),23)
           }

//           val intent = packageManager.getLaunchIntentForPackage("com.example.foodcart")
//           startActivity(intent)
       }
    }
}