package IntentDemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.demo.R

class LoginActivity : AppCompatActivity() {

    lateinit var username :EditText
    lateinit var password :EditText
    lateinit var btnSubmit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("OnCreate","OnCreateCalled!")
        username = findViewById<EditText>(R.id.userName)
        password = findViewById<EditText>(R.id.password)
        btnSubmit = findViewById<Button>(R.id.submit)

        btnSubmit.setOnClickListener(){
            print("")
            intent = Intent(applicationContext, HomeActivity::class.java)
            intent.putExtra("username",username.text)
            intent.putExtra("password",password.text)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStart","onStart Called!")
        username.setText("")
        password.setText("")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume","OnResumed Called!")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPause","OnPaused Called!")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","OnStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy","OnDestroy Called!")
    }
}