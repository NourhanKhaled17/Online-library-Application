package com.example.onlinelibraryapplication.views

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinelibraryapplication.adapters.ViewPagerAdapter
import com.example.onlinelibraryapplication.R
import kotlinx.android.synthetic.main.activity_onboarding.*


class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        supportActionBar!!.hide()

        //This Code to change status bar color in this activity only to Green Mint-->
        val window: Window = window
        window.statusBarColor = Color.parseColor("#5a795a")

        viewpager.adapter = ViewPagerAdapter(supportFragmentManager)
        dotsIndicator.attachTo(viewpager)
    }

    @SuppressLint("CommitPrefEdits")
    override fun onResume() {
        super.onResume()

        //This code to make this activity appear only once in the application after installation
        val prevStarted = "false"
        val sharedPreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

        if (!sharedPreferences.getBoolean(prevStarted, false)) {
            val editor = sharedPreferences.edit()
            editor.putBoolean(prevStarted, true)
            editor.apply()
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}