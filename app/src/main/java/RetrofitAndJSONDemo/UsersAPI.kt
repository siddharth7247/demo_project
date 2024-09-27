package RetrofitAndJSONDemo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersAPI {
    @GET("/api/users")
    fun getUsers():Call<List<UserDataModel>>

    @POST("api/users")
    fun addUser(@Body userDataModel: UserDataModel) : Call<UserDataModel>
}