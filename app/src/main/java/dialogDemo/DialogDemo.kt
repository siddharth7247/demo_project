package dialogDemo

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.R.id.txtDateOfBirth
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatterBuilder

class DialogDemo : AppCompatActivity() {

    lateinit var btnAdd :FloatingActionButton
    lateinit var btnSubmit : Button
    lateinit var txtFirstName : TextView
    lateinit var txtLastName  : TextView
    lateinit var txtDateOfBirth : TextView
    lateinit var studentRcView : RecyclerView
    lateinit var myadapter : StudentAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_demo)

        studentRcView = findViewById(R.id.studentRecyclerView)
        btnAdd = findViewById(R.id.btnAdd)

        var studentList = mutableListOf<StudentModel>()
        myadapter = StudentAdapter(studentList,this)
        studentRcView.adapter = myadapter

        btnAdd.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.add_user_form,null)


            txtFirstName = view.findViewById(R.id.txtFirstName)
            txtLastName = view.findViewById(R.id.txtLastName)
            txtDateOfBirth = view.findViewById(R.id.txtDateOfBirth)
            btnSubmit = view.findViewById(R.id.btnAddUser)

            //making builder for Dialog
            builder.setTitle("Add user")
            builder.setMessage("You want to add user")
            builder.setCancelable(true)
            builder.setView(view)

            val alertDialog = builder.create()
            alertDialog.show()

            txtDateOfBirth.setOnClickListener{

                val cal = Calendar.getInstance()
                val year = cal.get(Calendar.YEAR)
                val month = cal.get(Calendar.MONTH)
                val day = cal.get(Calendar.DAY_OF_MONTH)

                val datePicker = DatePickerDialog(
                    this,
                    {view, year, monthOfYear, dayOfMonth ->
                        var date = ((dayOfMonth).toString() + "/" + (monthOfYear + 1) + "/" + year)

//                        val formatter = DateTimeFormatterBuilder().appendPattern("dd.LLLL.yyyy").toFormatter()
//                        formatter.parse(date)
                        txtDateOfBirth.setText(date)
                    },
                    2002,12,14
                )
                datePicker.datePicker.setMaxDate(cal.timeInMillis)
                datePicker.show()
            }

            btnSubmit.setOnClickListener{
                alertDialog.dismiss()
                studentList.add(
                    StudentModel("${txtFirstName.text}","${txtLastName.text}","${txtDateOfBirth.text}")
                )
                myadapter.notifyDataSetChanged()
            }
        }

    }


}