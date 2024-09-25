package roomDataBaseDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.demo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text
import java.lang.Thread
import java.lang.Thread as Thread1

class RoomDatabaseDemoActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var itemAdapter : ItemAdapter
    lateinit var btnAddItem : FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database_demo)

        btnAddItem = findViewById(R.id.btnAddItem)
        btnAddItem.setOnClickListener{
            intent = Intent(this,AddItemActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.itemRecyclerView)
        Thread1 {
            val itemDB = Room.databaseBuilder(applicationContext,ItemDatabase::class.java,"itemsDB").fallbackToDestructiveMigration().build()
            val itemDao = itemDB.itemDao()
            val itemList : List<Item> = itemDao.getAll()
            itemAdapter = ItemAdapter(itemList)
            recyclerView.adapter = itemAdapter

            itemAdapter.onDeleteClick(object :btnDeleteClickListner{
                override fun btnDeleteClickListner(view: View, position: Int, item: Item) {
                    Thread{
                        itemDB.itemDao().delete(item)
                    }.start()

                }
            })
            itemAdapter.onUpdateClick(object :btnUpdateClickListner{
                override fun btnUpdateClickListner(view: View, position: Int, item: Item) {

                }
            })
        }.start()





    }
}