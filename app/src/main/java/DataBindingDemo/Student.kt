package DataBindingDemo

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

data class Student(
    val name: String,
    val surname: String,
    val email: String,
    val address: String,
    val birthDate: LocalDate,
    val img: Drawable?,
    val activity: Activity
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun onclick(student: Student) {
        val birthDate = student.birthDate
        val currentDate = LocalDate.now()
        val period = Period.between(birthDate, currentDate)
        val age = period.years
        Toast.makeText(activity, "$age Years", Toast.LENGTH_SHORT).show()
    }
}