package MultiThreadingDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class Demo1_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        var edtNum1 = findViewById<EditText>(R.id.txtNum1)
        var edtNum2 = findViewById<EditText>(R.id.txtNum2)
        var btnAdd = findViewById<Button>(R.id.btnSubmit)
        var txtResult = findViewById<TextView>(R.id.txtResult)


        var thread1 = Thread {
            Thread.sleep(1000)
            btnAdd.setOnClickListener {
                Log.d("Thread 1", "Thread 1 started")
                var sum = edtNum1.text.toString().toInt() + edtNum2.text.toString().toInt()
                txtResult.text = sum.toString()
            }

        }
        thread1.start()
    }

}
