package MenuDemo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class ContextMenu : AppCompatActivity() {
    lateinit var txtPress : TextView
    lateinit var layout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)

        txtPress = findViewById(R.id.txtPress)
        layout =  findViewById(R.id.constraintLayout)

        registerForContextMenu(txtPress)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("select Color")
        if (menu != null) {
            if (v != null) {
                menu.add(0,v.id,0,"Red")
                menu.add(0,v.id,0,"black")
                menu.add(0,v.id,0,"green")
                menu.add(0,v.id,0,"yellow")
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.title == "Red") {
            layout.setBackgroundColor(Color.RED)
        } else if (item.title == "black") {
            layout.setBackgroundColor(Color.BLACK)
        } else if (item.title == "green") {
            layout.setBackgroundColor(Color.GREEN)
        } else if (item.title == "yellow") {
            layout.setBackgroundColor(Color.YELLOW)
        } else {
        }
        return true
    }
}