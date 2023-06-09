package com.example.onlinelibraryapplication.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.view.WindowCompat
import com.example.onlinelibraryapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        startLoginActivity()
        animation()
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }

    private fun animation() {
        logo.animate().apply {
            alpha(0.0F)
        }.withEndAction {
            logo.animate().apply {
                logo.visibility = View.VISIBLE
                duration = 1500
                alpha(1.0F)
            }
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            desc.animate().apply {
                alpha(0.0F)
            }.withEndAction {
                desc.animate().apply {
                    desc.visibility = View.VISIBLE
                    duration = 1500
                    alpha(1.0F)
                }
            }
        }, 1000)
    }

    private fun startLoginActivity() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this@MainActivity, OnboardingActivity::class.java)
            startActivity(intent)
        }, 3500)
    }
}