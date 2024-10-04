package WorkManagerDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.demo.R

class WorkManagerDemo1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_demo1)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val txtStatus = findViewById<TextView>(R.id.txtStatus)

        val chargerConstarint: Constraints = Constraints.Builder().setRequiresCharging(true).build()
        val oneTimeRequest =
            OneTimeWorkRequest.Builder(OneTimeWorker::class.java).setConstraints(chargerConstarint)
                .build()


        btnStart.setOnClickListener {
            WorkManager.getInstance(this).enqueue(oneTimeRequest)
        }

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeRequest.id)
            .observe(this, Observer {
                val status = it.state.name
                Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
                txtStatus.text = status
            })
    }


}