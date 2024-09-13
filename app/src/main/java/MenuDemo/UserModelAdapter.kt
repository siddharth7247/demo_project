package MenuDemo

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class UserModelAdapter (var userList: List<UserModel>,var activity : Activity):RecyclerView.Adapter<UserModelAdapter.UserViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, iewType: Int):UserModelAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    class UserViewHolder(userView : View):RecyclerView.ViewHolder(userView){
        val txtName : TextView = userView.findViewById(R.id.txtName)
        val txtEmail : TextView = userView.findViewById(R.id.txtEmail)
        val btnEdit : Button = userView.findViewById(R.id.btnEdit)
    }

    override fun onBindViewHolder(holder: UserModelAdapter.UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.txtName.text = currentUser.name
        holder.txtEmail.text = currentUser.email
        holder.btnEdit.setOnClickListener{
            val popupMenu = PopupMenu(activity,holder.btnEdit)
            popupMenu.menuInflater.inflate(R.menu.action_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                Toast.makeText(activity, "You Clicked" + menuItem.title, Toast.LENGTH_SHORT).show()
                true
            }
            popupMenu.show()

        }
    }

    override fun getItemCount() = userList.size
}