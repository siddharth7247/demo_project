package RetrofitAndJSONDemo


import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserAdapter(
    var userList: MutableList<UserDataModel>?,
    var activity: Activity,
) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    lateinit var userUpdateListner: userClickListner
    lateinit var deleteUserClickListener: userClickListner

    override fun onCreateViewHolder(parent: ViewGroup, iewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return UserViewHolder(view)
    }

    class UserViewHolder(userView: View) : RecyclerView.ViewHolder(userView) {
        val txtName: TextView = userView.findViewById(R.id.txtName)
        val txtCompany: TextView = userView.findViewById(R.id.txtCompany)
        val txtAge: TextView = userView.findViewById(R.id.txtAge)
        val btnDelete: Button = userView.findViewById(R.id.btnDelete)
        val btnUpdate: Button = userView.findViewById(R.id.btnUpdate)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val currentUser = userList!![position]
        holder.txtName.text = currentUser.name
        holder.txtCompany.text = currentUser.company
        holder.txtAge.text = currentUser.age.toString()


        holder.btnDelete.setOnClickListener {
            RetrofitObject.Api.deleteUser(currentUser.userId)
                .enqueue(object : Callback<UserDataModel> {
                    override fun onResponse(
                        call: Call<UserDataModel>,
                        response: Response<UserDataModel>
                    ) {
                        userList!!.removeAt(position)
                        this@UserAdapter.notifyDataSetChanged()
                        Toast.makeText(activity, "deleted", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<UserDataModel>, t: Throwable) {
                        Toast.makeText(activity, "not deleted", Toast.LENGTH_SHORT).show()
                    }
                })
        }
        holder.btnUpdate.setOnClickListener {
            var builder = AlertDialog.Builder(activity)
            val view = LayoutInflater.from(activity).inflate(R.layout.add_user, null)

            builder.setTitle("Update User")
            builder.setMessage("You want to Update user")
            builder.setCancelable(true)
            builder.setView(view)

            var txtName: TextView = view.findViewById(R.id.txtName)
            var txtCompany: TextView = view.findViewById(R.id.txtCompany)
            var txtAge: TextView = view.findViewById(R.id.txtAge)
            var btnSubmit: Button = view.findViewById(R.id.btnAddUser)

            txtName.text = currentUser.name
            txtCompany.text = currentUser.company
            txtAge.text = currentUser.age.toString()

            val alertDialog = builder.create()
            alertDialog.show()

            btnSubmit.setOnClickListener {
                RetrofitObject.Api.updateUser(
                    currentUser.userId,
                    UserDataModel(
                        currentUser.userId,
                        txtName.text.toString(),
                        txtCompany.text.toString(),
                        txtAge.text.toString().toInt()
                    )
                ).enqueue(object : Callback<UserDataModel> {
                    override fun onResponse(
                        call: Call<UserDataModel>,
                        response: Response<UserDataModel>
                    ) {
                        alertDialog.dismiss()
                        userList!![position].name = txtName.text.toString()
                        userList!![position].company = txtCompany.text.toString()
                        userList!![position].age = txtAge.text.toString().toInt()
                        userList!![position].name = txtName.text.toString()

                        this@UserAdapter.notifyItemChanged(position)
                        Toast.makeText(activity, "updated", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<UserDataModel>, t: Throwable) {
                        Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

    override fun getItemCount() = userList!!.size

    fun onUserUpdateClick(listner: userClickListner) {
        this.userUpdateListner = listner
    }

    fun onDeleteClick(listner: userClickListner) {
        this.deleteUserClickListener = listner
    }

    fun updateList(newUserList: MutableList<UserDataModel>) {
        userList = newUserList
        notifyDataSetChanged()
    }
}