package dialogDemo

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R
import com.example.demo.R.id.logout
import java.time.Year
import java.util.Calendar

class precticeDialog : AppCompatActivity() {
    lateinit var btnLogout : Button
    lateinit var txtDate : TextView

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prectice_dialog)

        btnLogout = findViewById(R.id.logout1)
        txtDate = findViewById(R.id.txtDate)

        btnLogout.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Logout")
            builder.setMessage("Are you sure you want to logout!")
            builder.setCancelable(false)

            builder.setNegativeButton("yes"){
                dialog,which -> finish()
            }
            builder.setPositiveButton("no"){
               dialog,which -> dialog.cancel()
            }

            var alertDialog = builder.create()
            alertDialog.show()
        }

        txtDate.setOnClickListener{
            val cal = Calendar.getInstance()

            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                {view, year, monthOfYear, dayOfMonth ->
                    val date = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    txtDate.setText(date.toString())
                },
                year,month,day
            )
            datePicker.show()
            datePicker.datePicker.setMaxDate(cal.timeInMillis)
        }


    }
}