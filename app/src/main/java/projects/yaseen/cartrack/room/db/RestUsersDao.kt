package projects.yaseen.cartrack.room.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import projects.yaseen.cartrack.room.model.RestUserModel

@Dao
interface RestUsersDao {

    @Query("SELECT * FROM rest_users")
    fun getAllUsers(): LiveData<List<RestUserModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(userList: List<RestUserModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: RestUserModel)

    @Query("DELETE FROM rest_users")
    fun deleteAllUsers()
}
