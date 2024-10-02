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

    private lateinit var mainThreadHandler: Handler
    private lateinit var thread2Handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo2)

        val txtNum = findViewById<EditText>(R.id.txtNum)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtResult1 = findViewById<TextView>(R.id.txtResult1)
        val txtResult2 = findViewById<TextView>(R.id.txtResult2)

        mainThreadHandler = Handler(Looper.getMainLooper())

        btnSubmit.setOnClickListener {
            var thread1 = Thread {
                var num = txtNum.text.toString().toInt()
                var sum = num + num

                mainThreadHandler.post {
                    txtResult1.text = sum.toString()
                }
                var message = thread2Handler.obtainMessage(sum)
                //message.what = sum
                thread2Handler.sendMessage(message)
            }
            thread1.start()
        }

        var thread2 = Thread {
            Looper.prepare()

            thread2Handler = Handler(Looper.myLooper()!!)
            { message ->
                var sum = message.what
                Log.d("value of sum", sum.toString())
                var squre = sum.toString().toInt() * sum.toString().toInt()

                mainThreadHandler.post {
                    txtResult2.text = squre.toString()
                }
            }
            Looper.loop()
        }
        thread2.start()
    }
}
