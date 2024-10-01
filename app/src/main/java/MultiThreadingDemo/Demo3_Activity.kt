package MultiThreadingDemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.demo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class Demo3_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo3)

        var txtUrl = findViewById<EditText>(R.id.txtUrl)
        var imgView = findViewById<ImageView>(R.id.imgView)
        var btnGetImage = findViewById<Button>(R.id.btnSubmit)


        btnGetImage.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                var url = txtUrl.text
                var myUrl = URL(url.toString())
                imgView.load(myUrl.toString())
            }
        }
    }
}