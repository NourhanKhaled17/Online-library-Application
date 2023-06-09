package com.example.onlinelibraryapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.adapters.ReligionAdapter
import com.example.onlinelibraryapplication.repositories.myReligionField
import kotlinx.android.synthetic.main.activity_religion.*

class ReligionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_religion)

        religion_recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        religion_recyclerView.adapter = ReligionAdapter(myReligionField)

        //This code line to change color of items in status bar to black
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        //This code line to make window take all size of the screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        back3.setOnClickListener {
            finish()
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}