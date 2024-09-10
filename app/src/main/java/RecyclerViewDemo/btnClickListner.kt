package RecyclerViewDemo

import android.icu.text.Transliterator.Position
import android.view.View

interface btnClickListner {
    fun btnClickListner(view: View,position: Int,item : ItemModel)
}