package projects.yaseen.cartrack.room.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import projects.yaseen.cartrack.room.model.UserDatabaseModel


@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<UserDatabaseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(userList: List<UserDatabaseModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserDatabaseModel)

    @Query("DELETE FROM users")
    fun deleteAllUsers()
}
