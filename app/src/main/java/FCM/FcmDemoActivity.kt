package FCM

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R
import com.google.firebase.messaging.FirebaseMessaging

class FcmDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcm_demo)

        var txtToken = findViewById<TextView>(R.id.txtToken)
        var btnGenrate = findViewById<Button>(R.id.btnGenrate)

        btnGenrate.setOnClickListener {
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener { task ->
                    // this fail
                    if (!task.isSuccessful) {
                        Log.d(
                            "token",
                            "Fetching FCM registration token failed",
                            task.exception
                        )
                        return@addOnCompleteListener
                    }
                    //this token
                    val token = task.result
                    //to showing
                    txtToken.text = token
                    Toast.makeText(this, "get a token", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
