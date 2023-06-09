package com.example.onlinelibraryapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import com.example.onlinelibraryapplication.R
import kotlinx.android.synthetic.main.activity_author.*
import kotlinx.android.synthetic.main.activity_author.view.*

class AuthorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)

        val intent = intent
        val aImage = intent.getIntExtra("iImage", 0)
        val aName = intent.getStringExtra("iName")
        val aJob = intent.getStringExtra("iJob")
        val aDescription = intent.getStringExtra("iDescription")
        val aBooks = intent.getStringExtra("iBooks")
        val aBackgroundColor = intent.getIntExtra("iBackgroundColor", 0)

        author_image.setImageResource(aImage)
        author_name2.text = aName
        job.text = aJob
        description_author.text = aDescription
        his_books.text = aBooks
        author_app_bar.setBackgroundResource(aBackgroundColor)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        //This code line to make window take all size of the screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        //This code line to change color of items in status bar to black
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        back_author.setOnClickListener {
            finish()
        }
    }
}