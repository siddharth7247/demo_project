package DataBindingDemo

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.demo.R
import com.example.demo.databinding.ActivityDataBindingDemo2Binding
import java.time.LocalDate

class DataBindingDemo : AppCompatActivity() {
    lateinit var binding: ActivityDataBindingDemo2Binding
    lateinit var student: Student

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var img: Drawable? = ActivityCompat.getDrawable(this, R.drawable.profile)
        val dateOfBirth = LocalDate.of(2002, 12, 14)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_demo2)
        student = Student("Siddhartha", "Manana", "Savanna454", "Rajkot", dateOfBirth, img, this)
        binding.student = student
        binding.executePendingBindings()
    }
}