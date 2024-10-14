package WorkManagerDemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class WorkManagerIndex : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_index)

        val btnTask1 = findViewById<Button>(R.id.btnTask1)
        val btnTask2 = findViewById<Button>(R.id.btnTask2)

        btnTask1.setOnClickListener {
            intent = Intent(this, WorkManagerDemo1::class.java)
            startActivity(intent)
        }
        btnTask2.setOnClickListener {
            intent = Intent(this, WorkManagerDemo2::class.java)
            startActivity(intent)
        }
    }
}