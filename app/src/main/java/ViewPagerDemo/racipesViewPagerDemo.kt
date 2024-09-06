package ViewPagerDemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.demo.R
import com.google.android.material.tabs.TabLayout

class racipesViewPagerDemo : AppCompatActivity() {
    lateinit var tabLayout : TabLayout
    lateinit var viewPager : ViewPager2
    lateinit var adapter: RacipeFragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_racipes_view_pager_demo)

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager2>(R.id.viewPager)

        adapter = RacipeFragmentAdapter(supportFragmentManager,lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("BreakFast"))
        tabLayout.addTab(tabLayout.newTab().setText("Lunch"))
        tabLayout.addTab(tabLayout.newTab().setText("Dinner"))
        viewPager.adapter = adapter
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

    }
}