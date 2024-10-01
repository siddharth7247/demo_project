package MultiThreadingDemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class Demo2_Activity : AppCompatActivity() {

    private lateinit var mainHandler: Handler
    private lateinit var thread2Handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo2)

        val txtNum = findViewById<EditText>(R.id.txtNum)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtResult1 = findViewById<TextView>(R.id.txtResult1)
        val txtResult2 = findViewById<TextView>(R.id.txtResult2)

        mainHandler = Handler(Looper.getMainLooper())

        btnSubmit.setOnClickListener {
            var thread1 = Thread {
                var num = txtNum.text.toString().toInt()
                var sum = num + num

                mainHandler.post{
                    txtResult1.setText(sum.toString())
                }
                var message = thread2Handler.obtainMessage()
                message.arg1 = sum
                thread2Handler.sendMessage(message)
            }
            thread1.start()
        }
        var thread2 = Thread {
            Looper.prepare()

            thread2Handler = Handler(Looper.myLooper()!!) { message ->
                var sum = message.arg1
                var squre = sum * sum

                mainHandler.post {
                    txtResult2.setText(squre.toString())
                }
            }
            Looper.loop()
        }
        thread2.start()
    }
}
