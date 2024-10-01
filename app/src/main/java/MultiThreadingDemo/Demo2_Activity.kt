package MultiThreadingDemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class Demo2_Activity : AppCompatActivity() {
    lateinit var looper: Looper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo2)

        var txtNum = findViewById<EditText>(R.id.txtNum)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var txtReslt_1 = findViewById<TextView>(R.id.txtResult1)
        var txtResult_2 = findViewById<TextView>(R.id.txtResult2)


        var thread1 = Thread {
            btnSubmit.setOnClickListener {
                Log.d("Thread 1", "Thread 1 started")
                var sum = txtNum.text.toString().toInt() + txtNum.text.toString().toInt()

                var handler = Handler(looper)
                var message = handler.obtainMessage(sum)
                handler.sendMessage(message)


            }
        }
        thread1.start()

        var thread2 = Thread {
            looper = Looper.myLooper()!!
            // looper.p
        }
        thread2.start()
    }
}