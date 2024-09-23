package SharedPrefrencesDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.demo.R
import com.google.android.material.textfield.TextInputEditText


class EncryptedSharedPreferencesActivity : AppCompatActivity() {
    lateinit var edtUserName : TextInputEditText
    lateinit var edtPassword : TextInputEditText
    lateinit var btnLogin : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypted_shared_preferences)

        edtUserName = findViewById(R.id.idEdtName)
        edtPassword = findViewById(R.id.idEdtPass)
        btnLogin = findViewById(R.id.btnLogin)

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val encryptedSharedPreferences =  EncryptedSharedPreferences.create(
            "Users",
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM

        )

        btnLogin.setOnClickListener{
            encryptedSharedPreferences.edit().putString("userName",edtUserName.text.toString()).apply()
            encryptedSharedPreferences.edit().putString("password",edtPassword.text.toString()).apply()
            intent = Intent(applicationContext,HomeActivity::class.java)
            startActivity(intent)
        }
        if(encryptedSharedPreferences.contains("userName")){
            intent = Intent(applicationContext,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}