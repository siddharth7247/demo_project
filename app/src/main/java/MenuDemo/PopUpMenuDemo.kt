package MenuDemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class PopUpMenuDemo : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var myAdapter : UserModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_menu_demo)
        recyclerView = findViewById(R.id.recyclerView)
        var userList = listOf(UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"),UserModel("Sahil","s@gmail.com"))
        myAdapter = UserModelAdapter(userList,this)
        recyclerView.adapter = myAdapter

    }
}