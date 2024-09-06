package ViewPagerDemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 7
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
             0 -> Fragment_Sunday()
             1 -> Fragment_Monday()
             2 -> Fragment_Tuesday()
             3 -> Fragment_Sunday()
             4 -> Fragment_Monday()
             5 -> Fragment_Tuesday()
             6 -> Fragment_Tuesday()
            else -> Fragment_Sunday()
        }
    }
}