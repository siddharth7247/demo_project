package MultiThreadingDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class Task1_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        var edtNum1 = findViewById<EditText>(R.id.txtNum1)
        var edtNum2 = findViewById<EditText>(R.id.txtNum2)
        var btnAdd = findViewById<Button>(R.id.btnSubmit)
        var txtResult = findViewById<TextView>(R.id.txtResult)

        val myThread = Thread{
            btnAdd.setOnClickListener{
                var sum = edtNum1.text.toString().toInt() + edtNum2.text.toString().toInt()
                txtResult.setText(sum.toString())
            }
        }
        myThread.start()
    }
}