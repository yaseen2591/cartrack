package projects.yaseen.cartrack.model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var email: String, private var password: String, private var country: String) : BaseObservable() {


    fun isDataValid(): Int {
        if (TextUtils.isEmpty(getEmail())) {
            return 1
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 2
        } else if (TextUtils.isEmpty(getPassword())) {
            return 3
        } else if (getPassword().length <= 6) {
            return 4
        } else if (TextUtils.isEmpty(getCountry())) {
            return 5
        } else {
            return -1
        }

    }

    fun getPassword(): String {

        return password
    }

    fun getEmail(): String {

        return email
    }

    fun getCountry(): String {

        return country
    }


    fun setPassword(password: String) {
        this.password = password
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setCountry(country: String) {
        this.country = country
    }

}