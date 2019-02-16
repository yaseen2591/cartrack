package projects.yaseen.cartrack.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import projects.yaseen.cartrack.interfaces.LoginResultCallbacks

class  LoginViewModelFactory (val listener: LoginResultCallbacks) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}