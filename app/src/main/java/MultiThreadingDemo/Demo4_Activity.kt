package MultiThreadingDemo

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R


class Demo4_Activity : AppCompatActivity() {

    private lateinit var txtCounter: TextView
    private lateinit var btnStart: Button
    private var counterTask: CounterTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo4)

        txtCounter = findViewById(R.id.txtCounter)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            counterTask = CounterTask(this, txtCounter)
            counterTask?.execute()
        }
    }
}

class CounterTask(
    private val activity: Demo4_Activity,
    private val textView: TextView
) : AsyncTask<Void, Int, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        for (i in 0..10) {
            Thread.sleep(500)
            publishProgress(i)

            if (i == 10) {
                cancel(true)
            }
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        textView.text = "Counter: ${values[0]}"
    }

    override fun onPostExecute(result: Void?) {
        Toast.makeText(activity, "Counting completed!", Toast.LENGTH_SHORT).show()
    }

    override fun onCancelled() {
        Toast.makeText(activity, "Counting was cancelled!", Toast.LENGTH_SHORT).show()
    }
}