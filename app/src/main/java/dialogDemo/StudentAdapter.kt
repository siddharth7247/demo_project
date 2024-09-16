package dialogDemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R

class StudentAdapter(private var studentList: List<StudentModel>, context: Context) :RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): StudentAdapter.StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false)
        return  StudentViewHolder(view)
    }

    class StudentViewHolder(studentView : View) : RecyclerView.ViewHolder(studentView){
        var txtFirstName : TextView = studentView.findViewById(R.id.txtFname)
        var txtLastNAme : TextView = studentView.findViewById(R.id.txtLname)
        var txtBirtDate : TextView = studentView.findViewById(R.id.txtDob)
        var btnDelete : Button = studentView.findViewById(R.id.btnDelete)
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder, position: Int) {
        var currentStud = studentList.get(position)
        holder.txtFirstName.text = currentStud.firstname
        holder.txtLastNAme.text = currentStud.lastname
        holder.txtBirtDate.text = currentStud.birthdate
        holder.btnDelete.setOnClickListener{
            //studentList.re
        }
    }

    override fun getItemCount() = studentList.size


}