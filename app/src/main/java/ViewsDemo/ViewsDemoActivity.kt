package ViewsDemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class ViewsDemoActivity : AppCompatActivity() {
//    lateinit var firstName : EditText
//    lateinit var lastName : EditText
//    lateinit var email : EditText
//    lateinit var password : EditText
//    lateinit var gender : RadioButton
//    lateinit var mobileNo : EditText
//    lateinit var address : EditText
//    lateinit var btnSubmit : Button
//    lateinit var btnReset : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_views_demo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        firstName = findViewById(R.id.firstName)
//        lastName = findViewById(R.id.lastName)
//        email = findViewById(R.id.email)
//        password = findViewById(R.id.password)
//        gender = findViewById(R.id.radioGroup)
//        mobileNo = findViewById(R.id.phone)
//        address = findViewById(R.id.address)
//        btnSubmit = findViewById(R.id.btnSubmit)
//        btnReset = findViewById(R.id.btnReset)
    }
}