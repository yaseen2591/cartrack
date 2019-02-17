package projects.yaseen.cartrack.model

import android.arch.lifecycle.LiveData
import android.util.Log
import com.google.gson.Gson
import projects.yaseen.cartrack.App
import projects.yaseen.cartrack.rest.RestApi
import projects.yaseen.cartrack.room.model.RestUserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityRepository {

    val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val TAG = MainActivityRepository::class.java.simpleName

    fun getUsers() : LiveData<List<RestUserModel>>
    {
        return App.database!!.restUserDao().getAllUsers()

    }

    fun ApiCallAndPutInDB()
    {
        val gson = Gson()
        val retrofit =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getallUsers().enqueue(object : Callback<List<RestUserModel>> {

            override fun onFailure(call: Call<List<RestUserModel>>?, t: Throwable?) {
                Log.e(TAG,"OOPS!! something went wrong..")
            }

            override fun onResponse(call: Call<List<RestUserModel>>?, response: Response<List<RestUserModel>>?) {

                Log.e(TAG,response!!.body().toString())
                when(response.code())
                {
                    200 ->{
                        Thread(Runnable {

                            App.database!!.restUserDao().deleteAllUsers()
                            App.database!!.restUserDao().insertAllUsers(response.body()!!)
                        }).start()
                    }
                }

            }
        })


    }
}