package RetrofitAndJSONDemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class UserDetailsActivity : AppCompatActivity() {
    lateinit var btnGetUsers : Button
    lateinit var btnAddUser : FloatingActionButton
    lateinit var usersRecyclerView : RecyclerView
    lateinit var userAdapter: UserAdapter
    var userList : List<UserDataModel>? = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details2)

        btnGetUsers = findViewById(R.id.btnGetUsers)
        btnAddUser = findViewById(R.id.btnAdd)
        usersRecyclerView = findViewById(R.id.usersRecyclerView)

//        getUsersData()
//        userAdapter = UserAdapter(userList , this)
//        usersRecyclerView.adapter = userAdapter

        btnGetUsers.setOnClickListener{
            getUsersData()
            userAdapter = UserAdapter(userList ,this)
            usersRecyclerView.adapter = userAdapter
        }


        btnAddUser.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.add_user,null)

            builder.setTitle("Add user")
            builder.setMessage("You want to add user")
            builder.setCancelable(true)
            builder.setView(view)

            var txtName : TextView = view.findViewById(R.id.txtName)
            var txtCompany : TextView = view.findViewById(R.id.txtCompany)
            var txtAge : TextView = view.findViewById(R.id.txtAge)
            var btnSubmit : Button = view.findViewById(R.id.btnAddUser)
            val alertDialog = builder.create()
            alertDialog.show()

            btnSubmit.setOnClickListener{
                addUser(txtName.text.toString(),txtCompany.text.toString(),txtAge.text.toString().toInt())
                alertDialog.dismiss()
                getUsersData()
                userAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getUsersData()
    }

    fun addUser(name:String,company:String,age:Int){
        var user = UserDataModel("",name,company,age)
        RetrofitObject.Api.addUser(user).enqueue(object : Callback<UserDataModel>{
            override fun onResponse(
                call: Call<UserDataModel>,
                response: Response<UserDataModel>
            ) {
                Toast.makeText(this@UserDetailsActivity, "User Added", Toast.LENGTH_SHORT).show()
                getUsersData()
            }

            override fun onFailure(call: Call<UserDataModel>, t: Throwable) {
                Toast.makeText(this@UserDetailsActivity, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getUsersData(){
        RetrofitObject.Api.getUsers().enqueue(object : Callback<List<UserDataModel>> {
            override fun onResponse(
                call: Call<List<UserDataModel>>,
                response: Response<List<UserDataModel>>
            ) {
                userList = response.body()
                Log.d("Get user data",response.body().toString())
            }

            override fun onFailure(call: Call<List<UserDataModel>>, t: Throwable) {
                Toast.makeText(this@UserDetailsActivity, "not scuessfull", Toast.LENGTH_SHORT).show()
            }

        })
    }

}