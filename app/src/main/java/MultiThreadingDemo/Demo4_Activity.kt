package MultiThreadingDemo

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R


class Demo4_Activity : AppCompatActivity() {

    private lateinit var txtCounter: TextView
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo4)

        txtCounter = findViewById(R.id.txtCounter)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            var counterAsynckTask = CounterAsynkTask(this, txtCounter)
            counterAsynckTask.execute()
        }

    }
}

class CounterAsynkTask(
    var activity: Demo4_Activity, var txtCounter: TextView
) :
    AsyncTask<Any, Int, Any>() {
    @SuppressLint("WrongThread")
    override fun doInBackground(vararg p0: Any?): Any {
        for (i in 1..10) {
            Thread.sleep(600)
            publishProgress(i)

            if (i == 10) {
                cancel(true)
            }
        }
        return true
    }

    override fun onPreExecute() {
        super.onPreExecute()
        Toast.makeText(activity, "Asynck task started execute in backgroung!!", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        txtCounter.text = "${values[0]}"

    }

    override fun onCancelled() {
        super.onCancelled()
        Toast.makeText(activity, "Asynck task cancel", Toast.LENGTH_SHORT).show()
    }

    override fun onPostExecute(result: Any?) {
        super.onPostExecute(result)
        Toast.makeText(activity, "Async task completed", Toast.LENGTH_LONG).show()
    }

}

