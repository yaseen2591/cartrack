package projects.yaseen.cartrack

import android.app.Application
import android.arch.persistence.room.Room
import projects.yaseen.cartrack.room.db.CartrackDatabase

class App : Application() {
    companion object {
        var database: CartrackDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, CartrackDatabase::class.java, "cartrack_db").fallbackToDestructiveMigration().build()
    }

}