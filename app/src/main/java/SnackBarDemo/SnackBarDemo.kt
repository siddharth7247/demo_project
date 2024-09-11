package SnackBarDemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.demo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class SnackBarDemo : AppCompatActivity() {
    lateinit var btnPerson : FloatingActionButton
    lateinit var btnAlaram :FloatingActionButton
    lateinit var btnAdd : FloatingActionButton
    lateinit var btnEdit : FloatingActionButton
    lateinit var main : CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar_demo)

        btnAdd = findViewById(R.id.addFab)
        btnAlaram = findViewById(R.id.addAlarm)
        btnPerson = findViewById(R.id.addPerson)
        btnEdit = findViewById(R.id.edit)
        main = findViewById(R.id.main)

        var isVisble = false

        btnAdd.setOnClickListener {
            if (!isVisble) {
                btnAlaram.visibility = View.VISIBLE
                btnPerson.visibility = View.VISIBLE
                btnEdit.visibility = View.VISIBLE
                isVisble = true
            } else {
                btnAlaram.visibility = View.GONE
                btnPerson.visibility = View.GONE
                btnEdit.visibility = View.GONE
                isVisble = false
            }
        }
        btnPerson.setOnClickListener {
            val snackbar = Snackbar.make(main, "Person Addead", Snackbar.LENGTH_LONG).setAction("DELETE"){
                val snackbar = Snackbar.make(main,"Person Deleted",Snackbar.LENGTH_LONG)
                snackbar.show()
            }
            snackbar.show()
        }

        btnAlaram.setOnClickListener{
            val snackbar = Snackbar.make(main, "Alarm Addead", Snackbar.LENGTH_LONG).setAction("DELETE"){
                val snackbar = Snackbar.make(main,"Alarm Deleted",Snackbar.LENGTH_LONG)
                snackbar.show()
            }
            snackbar.show()
        }
        btnEdit.setOnClickListener{
            val snackbar = Snackbar.make(main, "Edit Clickd", Snackbar.LENGTH_LONG).setAction("DELETE"){
                val snackbar = Snackbar.make(main,"Edit Uncliked",Snackbar.LENGTH_LONG)
                snackbar.show()
            }
            snackbar.show()
        }
    }
}