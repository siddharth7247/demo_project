package RetrofitAndJSONDemo

import android.icu.text.Transliterator.Position
import android.view.View

interface userClickListner {

    fun userClickListner(view:View,position: Int,user : UserDataModel)
}



