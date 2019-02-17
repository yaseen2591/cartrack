package projects.yaseen.cartrack.room.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "rest_users")
data class RestUserModel (

    @PrimaryKey
    var id : Int,
    var name : String,
    var username : String,
    var email:String,
//    var address: String,
    var phone :String,
    var website : String
//    var company: Company
)

//data class Address(
//    var street : String,
//    var suite : String,
//    var city : String,
//    var zipcode : String,
//    var geo: Geo
//
//    )
//
//data class Geo(
//    var lat : Double,
//    var lng : Double
//)


//data class Company(
//    var name : String,
//    var catchPhrase : String,
//    var bs : String
//
//)

