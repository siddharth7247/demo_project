package roomDataBaseDemo

import android.icu.text.Transliterator.Position
import android.view.View

interface btnUpdateClickListner {
    fun btnUpdateClickListner(view:View,position: Int,item : Item)
}