package ReturnResultDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R
import com.example.demo.R.id.btnUpdate

class ReturnResultDemo : AppCompatActivity() {

    lateinit var btnUpdate : Button
    lateinit var txtUsername : TextView
    lateinit var txtEmail : TextView
    lateinit var txtAddress : TextView
    lateinit var imageView: ImageView
    val dataRequestCode = 200
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return_result_demo)

        btnUpdate = findViewById(R.id.btnUpdate)
        txtUsername = findViewById(R.id.txtUserName)
        txtEmail = findViewById(R.id.txtEmail)
        txtAddress = findViewById(R.id.txtAddress)
        imageView = findViewById(R.id.imageView1)



        btnUpdate.setOnClickListener{
            intent = Intent(applicationContext,EditActivity::class.java)
            intent.putExtra("userName",txtUsername.text)
            intent.putExtra("email",txtEmail.text)
            intent.putExtra("address",txtAddress.text)
            startActivityForResult(intent,dataRequestCode)
        }

        val image = registerForActivityResult(ActivityResultContracts.GetContent()){
            imageView.setImageURI(it)
        }
        imageView.setOnClickListener{
            image.launch("image/*")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == dataRequestCode){
            txtUsername.setText(data?.getStringExtra("userName"))
            txtEmail.setText(data?.getStringExtra("email"))
            txtAddress.setText(data?.getStringExtra("address"))
        }
    }
}