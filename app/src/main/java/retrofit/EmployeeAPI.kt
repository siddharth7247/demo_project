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
    fun addUser(@Body userDataModel: UserDataModel) : Call<UserDataModel>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") userId: String, @Body request: UserDataModel): Call<UserDataModel>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") userId : String) : Call<UserDataModel>
}