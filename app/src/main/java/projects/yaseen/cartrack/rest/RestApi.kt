package projects.yaseen.cartrack.rest

import projects.yaseen.cartrack.room.model.RestUserModel
import retrofit2.Call
import retrofit2.http.GET

interface RestApi{
    @GET("users")
    fun getallUsers() : Call<List<RestUserModel>>
}