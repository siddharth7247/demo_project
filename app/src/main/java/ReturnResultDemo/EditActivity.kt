package ReturnResultDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class EditActivity : AppCompatActivity() {

    lateinit var edtxtUserName : EditText
    lateinit var edtxtEmail : EditText
    lateinit var edtxtAddress : EditText
    lateinit var btnUpdate : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        edtxtUserName = findViewById(R.id.tfUserName)
        edtxtEmail = findViewById(R.id.tfEmail)
        edtxtAddress = findViewById(R.id.tfAddress)
        btnUpdate = findViewById(R.id.btnUpdate)

        var bundle : Bundle? = intent.extras
        var userName = bundle?.get("userName")
        var email = bundle?.get("email")
        var address = bundle?.get("address")

        edtxtUserName.setText(userName.toString())
        edtxtEmail.setText(email.toString())
        edtxtAddress.setText(address.toString())

        btnUpdate.setOnClickListener{
            userName = edtxtUserName.text
            email = edtxtEmail.text
            address = edtxtAddress.text

            intent = Intent(applicationContext,ReturnResultDemo::class.java)
            intent.putExtra("userName",userName.toString())
            intent.putExtra("email",email.toString())
            intent.putExtra("address",address.toString())

            setResult(10,intent)
            finish()
        }

    }
}