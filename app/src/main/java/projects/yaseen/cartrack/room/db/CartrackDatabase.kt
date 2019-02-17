package projects.yaseen.cartrack.room.db

import android.arch.persistence.room.*
import projects.yaseen.cartrack.room.model.RestUserModel
import projects.yaseen.cartrack.room.model.UserDatabaseModel


@Database(entities = [(UserDatabaseModel::class),(RestUserModel::class)], version = 1)
abstract class CartrackDatabase :RoomDatabase(){
    abstract fun userDao() : UserDao
    abstract fun restUserDao() : RestUsersDao
}
