package SharedPrefrencesDemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class UserDetailsActivity : AppCompatActivity() {
    lateinit var txtFirstName : EditText
    lateinit var txtLastName : EditText
    lateinit var txtEmail : EditText
    lateinit var txtPhone : EditText
    lateinit var txtAddress : EditText
    lateinit var btnsubmit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        txtFirstName =  findViewById(R.id.txtFirstName)
        txtLastName = findViewById(R.id.txtLastName)
        txtEmail = findViewById(R.id.txtEmail)
        txtPhone = findViewById(R.id.txtPhone)
        txtAddress = findViewById(R.id.txtAddress)
        btnsubmit = findViewById(R.id.btnSubmit)

        btnsubmit.setOnClickListener{

            val shp = getSharedPreferences("userData", MODE_PRIVATE)
            val myShp = shp.edit()

            myShp.putString("firstName",txtFirstName.text.toString())
            myShp.putString("lastName",txtLastName.text.toString())
            myShp.putString("email",txtEmail.text.toString())
            myShp.putString("phone",txtPhone.text.toString())
            myShp.putString("address",txtAddress.toString())

            myShp.apply()

            intent = Intent(applicationContext,UserProfileActivity::class.java)
            startActivity(intent)
        }
    }
}