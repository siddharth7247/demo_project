package MenuDemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class MenuDemo : AppCompatActivity() {
    lateinit var btnContextMenu: Button
    lateinit var btnPopUpMenu: Button
    lateinit var btnActionMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_demo)
        btnContextMenu = findViewById(R.id.contextMenu)
        btnActionMenu = findViewById(R.id.actionMenu)
        btnPopUpMenu = findViewById(R.id.popUpMenu)

        btnContextMenu.setOnClickListener {
            intent = Intent(applicationContext, ContextMenu::class.java)
            startActivity(intent)
        }
        btnActionMenu.setOnClickListener {
            intent = Intent(applicationContext, ActionMenuDemo::class.java)
            startActivity(intent)
        }
        btnPopUpMenu.setOnClickListener {
            intent = Intent(applicationContext, PopUpMenuDemo::class.java)
            startActivity(intent)
        }
    }
}