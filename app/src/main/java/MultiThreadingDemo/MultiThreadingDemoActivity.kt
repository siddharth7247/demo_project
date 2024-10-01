package MultiThreadingDemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class MultiThreadingDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_threading_demo)

        var btnDemo1 = findViewById<Button>(R.id.demo1)
        var btnDemo2 = findViewById<Button>(R.id.demo2)
        var btnDemo3 = findViewById<Button>(R.id.demo3)
        var btnDemo4 = findViewById<Button>(R.id.demo4)

        btnDemo1.setOnClickListener{
            intent = Intent(this,Demo1_Activity::class.java)
            startActivity(intent)
        }
        btnDemo2.setOnClickListener{
            intent = Intent(this,Demo2_Activity::class.java)
            startActivity(intent)
        }
        btnDemo3.setOnClickListener{
            intent = Intent(this,Demo3_Activity::class.java)
            startActivity(intent)
        }
        btnDemo4.setOnClickListener{
            intent = Intent(this,Demo4_Activity::class.java)
            startActivity(intent)
        }
    }
}