package RecyclerViewDemo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class UserAdapter(var userList : List<UserModel>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    class  UserViewHolder(userView : View):RecyclerView.ViewHolder(userView){
        var txtName:TextView = userView.findViewById(R.id.txtName)
        var txtemail : TextView = userView.findViewById(R.id.txtEmail)
        var image : ImageView = userView.findViewById(R.id.imgProfile)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.txtName.text = currentUser.name
        holder.txtemail.text = currentUser.email
    }

    override fun getItemCount() = userList.size


}