package projects.yaseen.cartrack.interfaces

import projects.yaseen.cartrack.model.User

interface  LoginResultCallbacks{
    fun onSuccess(user: User)
    fun onError(message: Int)
}