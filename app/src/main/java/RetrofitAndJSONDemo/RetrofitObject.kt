package RetrofitAndJSONDemo

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
   // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
   // interceptor.setLevelHttpLoggingInterceptor.Level.BODY)
    private val retrofit by lazy { Retrofit.Builder().baseUrl("https://cad7489854fd783c1ec3.free.beeceptor.com")
        .client(client)
        .addConverterFactory(
        GsonConverterFactory.create()).build()
    }
    val Api = retrofit.create(UsersAPI::class.java)
}