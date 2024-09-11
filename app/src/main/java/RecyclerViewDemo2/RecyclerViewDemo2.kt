package RecyclerViewDemo2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class RecyclerViewDemo2 : AppCompatActivity() {
    lateinit var myAdapter : UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_demo2)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var users = listOf(UserModel("R.drawable.img_1","abc","abc@gmail.com"),UserModel("R.drawable.img_1","abc","abc@gmail.com"),UserModel("R.drawable.img_1","abc","abc@gmail.com"),UserModel("R.drawable.img_1","abc","abc@gmail.com"),UserModel("R.drawable.img_1","abc","abc@gmail.com"),UserModel("R.drawable.img_1","abc","abc@gmail.com"))
        myAdapter = UserAdapter(users)
        recyclerView.adapter = myAdapter
    }
}