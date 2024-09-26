package roomDataBaseDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.demo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

            itemAdapter.onDeleteClick(object :btnClickListner{
                override fun btnClickListner(view: View, position: Int, item: Item) {
                    Thread{
                        itemDB.itemDao().delete(item)
                        itemAdapter.notifyItemRemoved(position)
                    }.start()
                }
            })
            itemAdapter.onUpdateClick(object :btnClickListner{
                override fun btnClickListner(view: View, position: Int, item: Item) {
                   intent = Intent(this@RoomDatabaseDemoActivity,AddItemActivity::class.java)
                    intent.putExtra("item",item)
                    startActivity(intent)
                }
            })
        }.start()
    }
}