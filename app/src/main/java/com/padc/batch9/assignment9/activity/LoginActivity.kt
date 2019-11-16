package com.padc.batch9.assignment9.activity


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.mvp.presenter.LoginPresenter
import com.padc.batch9.assignment9.mvp.view.LoginView
import com.padc.batch9.assignment9.util.Utils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {

    private lateinit var mPresenter: LoginPresenter

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showEmailEmptyError() {
        etEmail.error = getString(R.string.label_error_email)
        etEmail.requestFocus()
    }

    override fun showPasswordEmptyError() {
        etPassword.error = getString(R.string.label_error_password)
        etPassword.requestFocus()
    }

    override fun navigateToHome() {
       startActivity(PlantActivity.newIntent(this))
    }

    override fun doLogin(email: String, password: String) {
        val users = userModel.getUser()
        Log.i("Login", "users$users")
        if (users!=null) {
            navigateToHome()
        }
        else {
            showProgressBar()
            userModel.loginUser(email, password,
                {
                    navigateToHome()
                },
                {
                    showIdefiniteSnakBar(it)
                })
            hideProgressBar()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Utils.setStatusBarColor(this, R.color.textColorPrimary)
        mPresenter = ViewModelProviders.of(this).get(LoginPresenter::class.java)
        mPresenter.initPresenter(this)

        loadAnimations()

        btnLogin.setOnClickListener{
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            Log.i("Login", "Email$email\t$password")
            mPresenter.onTapLoginButton(email, password)}
    }

    private fun loadAnimations() {

        val labelSingInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        labelSingInAnim.interpolator = AccelerateDecelerateInterpolator()
        labelSingInAnim.setAnimationListener(object :Animation.AnimationListener {
             override fun onAnimationRepeat(p0: Animation?) {

             }

             override fun onAnimationStart(p0: Animation?) {
                 label_sign_in.visibility = View.VISIBLE
             }

             override fun onAnimationEnd(p0: Animation?) {
                label_sign_in.visibility = View.VISIBLE
             }
         })
        label_sign_in.startAnimation(labelSingInAnim)

        Handler().postDelayed(Runnable { val imageView2Anim = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            imageView2Anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationStart(p0: Animation?) {
                    imageView2.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(p0: Animation?) {
                    imageView2.visibility = View.VISIBLE
                }
            })
            imageView2.startAnimation(imageView2Anim) }, 1000)

       Handler().postDelayed(Runnable {
           val emailAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_right)
           etEmail.startAnimation(emailAnim)
       }, 1000)

       Handler().postDelayed(Runnable {
           val passwordAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_right)
           etPassword.startAnimation(passwordAnim)
       }, 1000)

      Handler().postDelayed(Runnable {
          val loginButtonAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_left)
          loginButtonAnim.setAnimationListener(object :Animation.AnimationListener{
              override fun onAnimationRepeat(p0: Animation?) {

              }

              override fun onAnimationEnd(p0: Animation?) {
                 btnLogin.visibility = View.VISIBLE
              }

              override fun onAnimationStart(p0: Animation?) {
                 btnLogin.visibility = View.VISIBLE
              }

          })
          btnLogin.startAnimation(loginButtonAnim)
      }, 1000)

    }
}
