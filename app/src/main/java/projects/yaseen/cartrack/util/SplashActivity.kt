package projects.yaseen.cartrack.util

import android.animation.Animator
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_splash.*
import projects.yaseen.cartrack.App
import projects.yaseen.cartrack.R
import projects.yaseen.cartrack.room.model.UserDatabaseModel
import projects.yaseen.cartrack.view.LoginActivity
import projects.yaseen.cartrack.view.MainActivity

class SplashActivity : AppCompatActivity(), Animator.AnimatorListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lottie_animation_view.playAnimation()
        lottie_animation_view.repeatCount = 1
        lottie_animation_view.addAnimatorListener(this)
    }


    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {

      val usersListViewModel : LiveData<List<UserDatabaseModel>> =  getUsers()

        usersListViewModel.observe(this, Observer<List<UserDatabaseModel>> { userList ->
            if (userList?.isEmpty()!!){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })


    }



    fun getUsers(): LiveData<List<UserDatabaseModel>> {
        return App.database!!.userDao().getAllUsers()
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }

}
