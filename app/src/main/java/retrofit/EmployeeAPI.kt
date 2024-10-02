package retrofit

import RetrofitAndJSONDemo.UserDataModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EmployeeAPI {
    @GET("/api/users")
    fun getUsers(): Call<List<UserDataModel>>

    @POST("api/users")
    fun addUser(@Body userDataModel: UserDataModel): Call<UserDataModel>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") userId: String, @Body request: UserDataModel): Call<UserDataModel>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") userId: String): Call<UserDataModel>
}


//class Demo4_Activity : AppCompatActivity() {
//
//    private lateinit var txtCounter: TextView
//    private lateinit var btnStart: Button
//    private var counterTask: CounterTask? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_demo4)
//
//        txtCounter = findViewById(R.id.txtCounter)
//        btnStart = findViewById(R.id.btnStart)
//
//        btnStart.setOnClickListener {
//            counterTask = CounterTask(this, txtCounter)
//            counterTask?.execute()
//        }
//    }
//}
//
//class CounterTask(
//    private val activity: Demo4_Activity,
//    private val textView: TextView
//) : AsyncTask<Void, Int, Void>() {
//
//    override fun doInBackground(vararg params: Void?): Void? {
//        for (i in 0..10) {
//            Thread.sleep(500)
//            publishProgress(i)
//
//            if (i == 10) {
//                cancel(true)
//            }
//        }
//        return null
//    }
//
//    override fun onProgressUpdate(vararg values: Int?) {
//        textView.text = "Counter: ${values[0]}"
//    }
//
//    override fun onPostExecute(result: Void?) {
//        Toast.makeText(activity, "Counting completed!", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onCancelled() {
//        Toast.makeText(activity, "Counting was cancelled!", Toast.LENGTH_SHORT).show()
//    }
//}