package SharedPrefrencesDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.demo.R
import com.example.demo.R.id.txtUserName

class HomeActivity : AppCompatActivity() {
    lateinit var txtUserName : TextView
    lateinit var btnLogout : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        txtUserName = findViewById(R.id.txtUserName)
        btnLogout = findViewById(R.id.btnLogout)
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val encryptedSharedPreferences =  EncryptedSharedPreferences.create(
            "Users",
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM

        )
        val userName = encryptedSharedPreferences.getString("userName","")
        txtUserName.setText("Welcome, ${userName}")


        btnLogout.setOnClickListener{
            val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            val encryptedSharedPreferences =  EncryptedSharedPreferences.create(
                "Users",
                masterKeyAlias,
                applicationContext,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM

            )
            encryptedSharedPreferences.edit().remove("userName").apply()
            intent = Intent(applicationContext,EncryptedSharedPreferencesActivity::class.java)
            startActivity(intent)
        }
    }
}