package FragmentDemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R

class FragmentDemo1 : AppCompatActivity() {
    lateinit var btn1: Button
    lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        var fragment: View? = findViewById(R.id.fragment)

        btn1.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val transection = fragmentManager.beginTransaction()
            transection.add(R.id.fragment, Fragment1())
            transection.commit()
        }
        btn2.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val transection = fragmentManager.beginTransaction()
            transection.add(R.id.fragment, Fragment2())
            transection.commit()
        }
    }

}