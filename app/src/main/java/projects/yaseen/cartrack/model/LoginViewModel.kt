package projects.yaseen.cartrack.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import projects.yaseen.cartrack.interfaces.LoginResultCallbacks
import projects.yaseen.cartrack.room.model.UserDatabaseModel

class LoginViewModel(private val listener: LoginResultCallbacks) : ViewModel() {
    private val user: User

    init {
        this.user = User("", "", "")
    }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }


        }


    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }


    val countryTextWatcher: TextWatcher
        get() = object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                user.setCountry(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    fun OnLoginClicked(view: View) {
        var loginCode: Int = user.isDataValid()

        if (loginCode == -1)
            listener.onSuccess(user)
        else
            listener.onError(loginCode)
    }



}
