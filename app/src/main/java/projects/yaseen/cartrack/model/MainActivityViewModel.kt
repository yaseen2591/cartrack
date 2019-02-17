package projects.yaseen.cartrack.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import projects.yaseen.cartrack.room.model.RestUserModel

class MainActivityViewModel : ViewModel() {

    lateinit var mainActivityRepository: MainActivityRepository

    init {
        mainActivityRepository = MainActivityRepository()
    }

    fun getAllCountryList(): LiveData<List<RestUserModel>>
    {
        return mainActivityRepository.getUsers()
    }

    fun getCountriesFromAPIAndStore()
    {
        mainActivityRepository.ApiCallAndPutInDB()
    }


}