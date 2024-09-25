package FontsDemo

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class FontDemo : AppCompatActivity() {

     val txtParagraph by lazy {  findViewById<TextView>(R.id.txtParagraph)}
    lateinit var btnRoman : Button
    lateinit var btnProtest : Button
    lateinit var btnAgbalumo : Button
    val x by lazy { 45 }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font_demo)

        btnRoman = findViewById(R.id.btnRoman)
        btnProtest = findViewById(R.id.btnProtest)
        btnAgbalumo = findViewById(R.id.btnAgblumo)

        val fontProtest = resources.getFont(R.font.fonts)
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