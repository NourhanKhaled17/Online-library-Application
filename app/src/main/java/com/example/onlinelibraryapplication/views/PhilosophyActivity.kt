package com.example.onlinelibraryapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.adapters.PhilosophyAdapter
import com.example.onlinelibraryapplication.repositories.myPhilosophyFields
import kotlinx.android.synthetic.main.activity_philosophy.*

class PhilosophyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_philosophy)

        philosophy_recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        philosophy_recyclerView.adapter = PhilosophyAdapter(myPhilosophyFields)

        //This code line to change color of items in status bar to black
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        //This code line to make window take all size of the screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        back_philosophy.setOnClickListener {
            finish()
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}