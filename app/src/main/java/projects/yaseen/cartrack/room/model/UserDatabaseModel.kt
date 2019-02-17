package projects.yaseen.cartrack.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class UserDatabaseModel(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String= "",
    @ColumnInfo(name = "email") var email: String = "",
    @ColumnInfo(name = "country") var country: String = "",
    @ColumnInfo(name = "token") var authToken: String = ""
) {
}