package roomDataBaseDemo

import RecyclerViewDemo.btnClickListner
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class ItemAdapter(private val itemList : List<Item>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    lateinit var updateListner : btnUpdateClickListner
    lateinit var deleteListner : btnDeleteClickListner

    class ItemViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var title :TextView= itemView.findViewById(R.id.txtTitle)
        var time :TextView = itemView.findViewById(R.id.txtTime)
        var update : Button = itemView.findViewById(R.id.edit)
        var delete : Button = itemView.findViewById(R.id.delete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.title.text = currentItem.name
        holder.time.text = currentItem.createdAt
        holder.update.setOnClickListener{
            updateListner.btnUpdateClickListner(holder.itemView,position,currentItem)
        }
        holder.delete.setOnClickListener{
            deleteListner.btnDeleteClickListner(holder.itemView,position,currentItem)
        }
    }

    override fun getItemCount() = itemList.size

    fun onUpdateClick (listner: btnUpdateClickListner){
        this.updateListner = listner
    }
    fun onDeleteClick (listner: btnDeleteClickListner){
        this.deleteListner = listner
    }

}