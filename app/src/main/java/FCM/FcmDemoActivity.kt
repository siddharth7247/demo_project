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

        val bundel: Bundle? = intent.extras

        if (bundel != null) {
            val name = bundel.get("name")
            txtToken.text = name.toString()
        }
        btnGenrate.setOnClickListener {
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.d(
                            "token",
                            "Fetching FCM registration token failed",
                            task.exception
                        )
                        return@addOnCompleteListener
                    }
                    val token = task.result
                    Log.d("Token", token.toString())
                    txtToken.text = token
                    Toast.makeText(this, "get a token", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
