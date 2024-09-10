package RecyclerViewDemo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class DetailsActivity : AppCompatActivity() {
    lateinit var txtName : TextView
    lateinit var txtRollNo : TextView
    lateinit var txtPhone : TextView
    lateinit var txtEmail : TextView
    lateinit var txtAddress :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details2)

        txtName = findViewById(R.id.name)
        txtRollNo = findViewById(R.id.rollNo)
        txtPhone = findViewById(R.id.phone)
        txtEmail = findViewById(R.id.eml)
        txtAddress = findViewById(R.id.add)

        var bundle : Bundle? = intent.extras

        var name = bundle?.get("name")
        var rollNo = bundle?.get("rollNo")
        var phone = bundle?.get("phone")
        var email = bundle?.get("email")
        var address = bundle?.get("address")

        txtName.text = name.toString()
        txtRollNo.text = rollNo.toString()
        txtPhone.text = phone.toString()
        txtEmail.text = email.toString()
        txtAddress.text = address.toString()
    }
}