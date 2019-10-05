package com.padc.batch9.assignment9.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padc.batch9.assignment9.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            startActivity(PlantActivity.newIntent(this))
        }

    }
}
