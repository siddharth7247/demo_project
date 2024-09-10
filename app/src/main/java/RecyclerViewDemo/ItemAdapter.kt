import ConstraintLayoutDemo.ConstraintLayoutDemo
import RecyclerViewDemo.ItemModel
import RecyclerViewDemo.btnClickListner
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R


class ItemAdapter(private val itemList: List<ItemModel>, context: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    lateinit var listner: btnClickListner



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_user, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView = itemView.findViewById(R.id.txtName)
        var textViewRollNo : TextView = itemView.findViewById(R.id.txtRollNo)
        var btnDetails : Button = itemView.findViewById(R.id.btnDetails)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.textViewName.text = currentItem.name
        holder.textViewRollNo.text = currentItem.rollno.toString()
        holder.btnDetails.setOnClickListener{
            listner.btnClickListner(holder.itemView,position,currentItem)
        }
    }

    override fun getItemCount() = itemList.size

    fun onbtnClick(listner: btnClickListner){
        this.listner = listner
    }
}
