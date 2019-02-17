package projects.yaseen.cartrack.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import projects.yaseen.cartrack.R
import kotlinx.android.synthetic.main.activity_login.*
import projects.yaseen.cartrack.App
import projects.yaseen.cartrack.interfaces.LoginResultCallbacks
import projects.yaseen.cartrack.databinding.ActivityLoginBinding
import projects.yaseen.cartrack.model.LoginViewModel
import projects.yaseen.cartrack.model.LoginViewModelFactory
import projects.yaseen.cartrack.model.User
import projects.yaseen.cartrack.room.model.UserDatabaseModel


class LoginActivity : AppCompatActivity(), LoginResultCallbacks {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val activityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        activityLoginBinding.viewModel =
                ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)

        country.setOnClickListener { view ->
            showCountries()
        }

        val frameAnimation = coordinatorlayout.getBackground() as AnimationDrawable
        frameAnimation.setEnterFadeDuration(2000)
        frameAnimation.setExitFadeDuration(4000)
        frameAnimation.start()
    }


    override fun onSuccess(user: User) {

        Thread(Runnable {
            App.database!!.userDao().deleteAllUsers()
            val userModel: UserDatabaseModel = UserDatabaseModel()
            userModel.email = user.getEmail()
            userModel.authToken = java.util.UUID.randomUUID().toString()
            userModel.country = user.getCountry()

            App.database!!.userDao().insertUser(userModel)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }).start()
    }

    override fun onError(validationCode: Int) {
        input_layout_email.error = null
        input_layout_country.error = null
        input_layout_password.error = null

        if (validationCode == 5) {
            input_layout_country.error = getString(R.string.error_empty_country)
        }
        if (validationCode == 2) {
            input_layout_email.error = getString(R.string.error_invalid_email)
            email.requestFocus()
        }
        if (validationCode == 1) {
            input_layout_email.error = getString(R.string.error_empty_email)
            email.requestFocus()
        }
        if (validationCode == 4) {
            input_layout_password.error = getString(R.string.error_invalid_password)
            password.requestFocus()
        }
        if (validationCode == 3) {
            input_layout_password.error = getString(R.string.error_empty_password)
            password.requestFocus()
        }
    }

    fun showCountries() {
        val items = resources.getStringArray(R.array.countries_with_cartrack_services)
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("Select a Country")
            setItems(items) { dialog, which ->
                country.setText(items[which])
            }
            show()
        }
    }


}
