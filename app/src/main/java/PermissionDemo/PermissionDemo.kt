package PermissionDemo

import android.Manifest
import android.annotation.SuppressLint
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
        var btnCamera: Button = findViewById(R.id.btnCamera)
        var btnLocation : Button = findViewById(R.id.btnLocation)
        var btnStorage : Button = findViewById(R.id.btnStorage)

        btnLocation.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)
            }else{
                Toast.makeText(this, "Location Permission is alredy Granted", Toast.LENGTH_SHORT).show()
            }
        }
        btnCamera.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),2)
            }else{
                Toast.makeText(this, "Camrea Permission is alredy Granted", Toast.LENGTH_SHORT).show()
            }
        }
        btnStorage.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),3)
            }else{
                Toast.makeText(this, "Read Storage Permission is alredy Grantd", Toast.LENGTH_SHORT).show()
            }


        }
    }
}