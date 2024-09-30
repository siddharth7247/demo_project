package IntentFilterDemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class IntentFilterDemoActivity : AppCompatActivity() {
    lateinit var txtMessage : TextView
    lateinit var btnGmail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_filter_demo)

        txtMessage = findViewById(R.id.txtMessage)
        btnGmail = findViewById(R.id.btnGmail)

        val message = intent.getStringExtra(Intent.EXTRA_TEXT)

        if(intent.type == "image/*"){
            txtMessage.setText(message.toString())
        }
        btnGmail.setOnClickListener{
            intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "smakavana454@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a dummy message")
            intent.putExtra(Intent.EXTRA_TEXT, "Dummy test message")
            intent.putExtra(Intent.EXTRA_CC,"ssojitra912@rku.ac.in")
            startActivity(intent
            )
        }
    }
}