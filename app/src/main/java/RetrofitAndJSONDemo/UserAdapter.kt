package RetrofitAndJSONDemo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class UserAdapter (var userList: List<UserDataModel>?):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, iewType: Int):UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false)
        return UserViewHolder(view)
    }

    class UserViewHolder(userView : View):RecyclerView.ViewHolder(userView){
        val txtName : TextView = userView.findViewById(R.id.txtName)
        val txtCompany : TextView = userView.findViewById(R.id.txtCompany)
        val txtAge : TextView =  userView.findViewById(R.id.txtAge)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val currentUser = userList?.get(position)
        holder.txtName.text = currentUser?.name
        holder.txtCompany.text = currentUser?.company
        holder.txtAge.text = currentUser?.age.toString()

    }

    override fun getItemCount() = userList!!.size
}