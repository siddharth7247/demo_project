package RecyclerViewDemo

import ItemAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class RecyclerViewDemo : AppCompatActivity() {

    lateinit var myAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_demo)

       var recyclerView : RecyclerView= findViewById(R.id.recyclerView)

        val items = listOf(
            ItemModel("sahil",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("vishal",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("ajay",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("vivek",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("raj",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("manish",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("kausal",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("pankaj",21,90811123,"s@gmail.com","Bhadla"),
            ItemModel("prem",21,90811123,"s@gmail.com","Bhadla"),
            )

        myAdapter = ItemAdapter(items,this)
        recyclerView.adapter = myAdapter

        myAdapter.onbtnClick(object : btnClickListner{
            override fun btnClickListner(view: View, position: Int, item: ItemModel) {
                intent = Intent(applicationContext, DetailsActivity::class.java)
                intent.putExtra("Item",item)
                startActivity(intent)
            }
        })

    }
}