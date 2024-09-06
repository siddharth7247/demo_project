package ViewPagerDemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class RacipeFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
             0 -> BreakFastFragment()
             1 -> LunchFragment()
             2 -> DinnerFragment()
            else -> LunchFragment()
        }
    }
}
