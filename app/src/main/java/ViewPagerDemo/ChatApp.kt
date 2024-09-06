package ViewPagerDemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.demo.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ChatApp : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var myAdapter: ChatScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat_app)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager)
        myAdapter = ChatScreenAdapter(this)
        viewPager2.adapter = myAdapter

        TabLayoutMediator(tabLayout,viewPager2){
            tab : TabLayout.Tab,position :Int ->

            when(position){
                0 -> {
                    tab.text = "Chats"
                    tab.setIcon(R.drawable.ic_home_black_24dp)
                }
                1 ->{
                    tab.text = "Status"
                    tab.setIcon(R.drawable.ic_dashboard_black_24dp)
                }
                2 ->{
                    tab.text = "Calls"
                    tab.setIcon(R.drawable.ic_notifications_black_24dp)
                }
                3 ->{
                    tab.text = "Video"
                    tab.setIcon(R.drawable.ic_notifications_black_24dp)
                }
            }
        }.attach()
    }
}