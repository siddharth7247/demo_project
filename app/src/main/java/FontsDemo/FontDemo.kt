package FontsDemo

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.demo.R
import com.example.demo.R.font.protest_fonts
import com.example.demo.R.layout.dropdown_item

class FontDemo : AppCompatActivity() {

    lateinit var txtParagraph : TextView
    lateinit var btnRoman : Button
    lateinit var btnProtest : Button
    lateinit var btnAgbalumo : Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font_demo)

        txtParagraph = findViewById(R.id.txtParagraph)
        btnRoman = findViewById(R.id.btnRoman)
        btnProtest = findViewById(R.id.btnProtest)
        btnAgbalumo = findViewById(R.id.btnAgblumo)

        val fontProtest = resources.getFont(R.font.protest_fonts)
        val fontRoboto = resources.getFont(R.font.roboto)
        val fontPoppins = resources.getFont(R.font.poppins)

        btnProtest.setOnClickListener{
            txtParagraph.typeface = fontProtest
        }
        btnRoman.setOnClickListener{
            txtParagraph.typeface = fontRoboto
        }
        btnAgbalumo.setOnClickListener{
            txtParagraph.typeface = fontPoppins
        }

    }
}