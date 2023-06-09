package com.example.onlinelibraryapplication.views

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.WindowCompat
import com.example.onlinelibraryapplication.R
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val intent = intent

        val aTitle = intent.getStringExtra("iTitle")
        val aDescription = intent.getStringExtra("iDescription")
        val aImage = intent.getIntExtra("iImage", 0)
        val aAuthor = intent.getStringExtra("iAuthor")
        val aRate = intent.getStringExtra("iRate")
        val aPages = intent.getStringExtra("iPages")
        val aLanguage = intent.getStringExtra("iLanguage")
        val aPrice = intent.getStringExtra("iPrice")
        val aAboutAuthor = intent.getStringExtra("iAboutAuthor")
        val aURLRead = intent.getStringExtra("iURLRead")
        val aURLListen = intent.getStringExtra("iURLListen")

        image_book.setImageResource(aImage)
        description_book.text = aDescription
        title_book.text = aTitle
        author.text = aAuthor
        rate.text = aRate
        pages.text = aPages
        language.text = aLanguage
        price.text = aPrice
        about.text = aAboutAuthor

        button_read.setOnClickListener {
            startActivity(
                Intent(this, BookViewActivity::class.java).putExtra("url", aURLRead)
            )
        }

        if (aURLListen == "none") {
            button_listen.visibility = View.GONE
            button_read.setBackgroundResource(R.drawable.buy_button_custom)
            button_read.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        } else {
            button_listen.setOnClickListener {
                startActivity(
                    Intent(this, BookViewActivity::class.java).putExtra("url", aURLListen)
                )
            }
        }

        //This code line to make window take all size of the screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        back_book.setOnClickListener {
            finish()
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        changeFavouriteColor()
    }

    private fun changeFavouriteColor() {
        var clicked = 0
        favorite.setOnClickListener {
            clicked++
            if (clicked % 2 != 0) {
                favorite.setColorFilter(Color.parseColor("#CD0000"))
            } else {
                favorite.setColorFilter(Color.WHITE)
            }
        }
    }
}