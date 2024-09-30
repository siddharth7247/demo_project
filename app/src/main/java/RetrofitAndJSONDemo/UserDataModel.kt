package RetrofitAndJSONDemo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserDataModel( @SerializedName("id") var userId : String,var name:String,var company : String, var age:Int):Serializable