package ListViewDemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class ListViewDemo : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var arrayAdapter: ArrayAdapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_demo)

        listView = findViewById<ListView>(R.id.listView)
        var sports = listOf<String>("Cricket","football","hockey","vollyball","Cricket","football","hockey","vollyball")
        arrayAdapter = ArrayAdapter (this, android.R.layout.simple_list_item_1,sports)
        listView.adapter = arrayAdapter
    }
}