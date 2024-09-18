package FragmentDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.demo.R
import com.example.demo.R.id.btn11
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentDemo : AppCompatActivity() {
    lateinit var bottomNavBar : BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo2)

        bottomNavBar = findViewById(R.id.bottomNavBar)

        bottomNavBar.setOnItemSelectedListener{
            when(it.itemId){
                    R.id.home -> {
                        loadFragment(Fragment1())
                        true
                    }
                    R.id.search ->{
                        loadFragment(Fragment2())
                        true
                    }
                    R.id.delete ->{
                        loadFragment(Fragment3())
                        true
                    }
                    R.id.profile -> {
                        loadFragment(Fragment4())
                        true
                    }
                    else -> {
                        loadFragment(Fragment1())
                        true
                }
            }
        }
    }


    fun loadFragment(fragment : Fragment){
        val transection = supportFragmentManager.beginTransaction()
        transection.replace(R.id.fragmentContainer,fragment)
        transection.addToBackStack(fragment.tag)
        transection.commit()
    }
}