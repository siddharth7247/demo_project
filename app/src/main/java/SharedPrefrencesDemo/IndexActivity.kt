package SharedPrefrencesDemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class IndexActivity : AppCompatActivity() {
    lateinit var btnSharedPreferences : Button
    lateinit var btnEncryptrdSharedPreferences : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        btnSharedPreferences = findViewById(R.id.btnSharedPrefernces)
        btnEncryptrdSharedPreferences = findViewById(R.id.btnEncryptrdSharedPrefernces)

        btnSharedPreferences.setOnClickListener{
            intent = Intent(applicationContext,UserDetailsActivity::class.java)
            startActivity(intent)
        }
        btnEncryptrdSharedPreferences.setOnClickListener{
            intent = Intent(applicationContext,EncryptedSharedPreferencesActivity::class.java)
            startActivity(intent)
        }
    }
}