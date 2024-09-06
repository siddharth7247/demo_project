
package ViewPagerDemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.R

class ViewPagerDemo : AppCompatActivity() {

    lateinit var btnWeatherApp : Button
    lateinit var btnRacipeApp : Button
    lateinit var btnInfinityApp : Button
    lateinit var btnChatApp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_pager_demo)

        btnWeatherApp = findViewById(R.id.weatherViewPager)
        btnRacipeApp = findViewById(R.id.racipeViewPager)
        btnInfinityApp =  findViewById(R.id.infinitViewPager)
        btnChatApp = findViewById(R.id.chatApp)

        btnWeatherApp.setOnClickListener(){
            intent = Intent(applicationContext,WeatherViewPager::class.java)
            startActivity(intent)
        }
        btnRacipeApp.setOnClickListener(){
            intent = Intent(applicationContext,racipesViewPagerDemo::class.java)
            startActivity(intent)
        }
        btnInfinityApp.setOnClickListener(){
            intent = Intent(applicationContext,InfinityViewPager::class.java)
            startActivity(intent)
        }
        btnChatApp.setOnClickListener(){
            intent = Intent(applicationContext,ChatApp::class.java)
            startActivity(intent)
        }

    }
}