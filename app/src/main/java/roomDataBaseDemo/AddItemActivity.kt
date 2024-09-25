package roomDataBaseDemo

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.demo.R
import com.example.demo.R.id.btnAddItem

class AddItemActivity : AppCompatActivity() {
    lateinit var edtItem : EditText
    lateinit var btnAddItem  : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        edtItem = findViewById(R.id.idEdtItem)
        btnAddItem = findViewById(R.id.btnAdd)

        btnAddItem.setOnClickListener{
            var title : String = edtItem.text.toString()
            var time = Calendar.getInstance().time.toString()

            Thread {
                val itemDB =
                    Room.databaseBuilder(applicationContext, ItemDatabase::class.java, "itemsDB")
                        .fallbackToDestructiveMigration().build()
                val itemDao = itemDB.itemDao()
                val item = Item(null, title, time)
                itemDB.itemDao().insertAll(item)
            }.start()
            intent = Intent(this,RoomDatabaseDemoActivity::class.java)
            startActivity(intent)
        }

    }
}