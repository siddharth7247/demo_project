package ViewsDemo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class DetailsActivity : AppCompatActivity() {
    lateinit var firstName : TextView
    lateinit var lastName : TextView
    lateinit var Email : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        firstName = findViewById(R.id.name)
        lastName = findViewById(R.id.rollNo)
        Email = findViewById(R.id.eml)

        var bundle : Bundle? = intent.extras
        val firstname = bundle?.get("firstname")
        val lastname = bundle?.get("lastname")
        val email = bundle?.get("email")

        firstName.text = firstname.toString()
        lastName.text = lastname.toString()
        Email.text = email.toString()
    }
}