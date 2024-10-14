package RetrofitAndJSONDemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://cad7489854fd783c1ec3.free.beeceptor.com")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    }
    val Api = retrofit.create(UsersAPI::class.java)
}