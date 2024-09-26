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

        var item = intent.getSerializableExtra("Item") as ItemModel

        txtName.text = item.name
        txtRollNo.text = item.rollno.toString()
        txtPhone.text = item.phone.toString()
        txtEmail.text = item.email
        txtAddress.text = item.address
    }
}