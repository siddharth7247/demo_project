package ViewPagerDemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ChatScreenAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Fragment_Sunday()
            1 -> Fragment_Monday()
            2 -> Fragment_Tuesday()
            else -> Fragment_Sunday()
        }
    }
}