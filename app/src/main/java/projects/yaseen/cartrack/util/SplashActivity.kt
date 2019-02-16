package projects.yaseen.cartrack.util

import android.animation.Animator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import projects.yaseen.cartrack.R
import projects.yaseen.cartrack.login.LoginActivity

class SplashActivity : AppCompatActivity() , Animator.AnimatorListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lottie_animation_view.playAnimation()
        lottie_animation_view.repeatCount=1
        lottie_animation_view.addAnimatorListener(this)
    }


    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }

}
