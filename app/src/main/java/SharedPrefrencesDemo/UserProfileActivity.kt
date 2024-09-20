package SharedPrefrencesDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R
import com.example.demo.R.id.lastName
import com.example.demo.R.id.phone
import com.example.demo.R.id.txtFirstName

class UserProfileActivity : AppCompatActivity() {

    lateinit var txtFirstName : TextView
    lateinit var txtLastName : TextView
    lateinit var txtEmail : TextView
    lateinit var txtPhone : TextView
    lateinit var txtAddress : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        txtFirstName = findViewById(R.id.firstName)
        txtLastName = findViewById(R.id.lastName1)
        txtEmail = findViewById(R.id.email)
        txtPhone = findViewById(R.id.phone)
        txtAddress = findViewById(R.id.address)

        val sh = getSharedPreferences("userData", MODE_PRIVATE)

        val firstName = sh.getString("firstName","")
        val lastName = sh.getString("lastName","")
        val email = sh.getString("email","")
        val phone = sh.getString("phone","")
        val address = sh.getString("address" ,"")

        txtFirstName.setText(firstName)
        txtLastName.setText(lastName)
        txtEmail.setText(email)
        txtPhone.setText(phone)
        txtAddress.setText(address)

    }
}