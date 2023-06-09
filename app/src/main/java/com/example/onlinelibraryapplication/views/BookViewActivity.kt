package com.example.onlinelibraryapplication.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.core.view.WindowCompat
import com.example.onlinelibraryapplication.R
import kotlinx.android.synthetic.main.activity_book_view.*

class BookViewActivity : AppCompatActivity() {
    private lateinit var url: String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_view)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val uri = intent.getStringExtra("url")
        url = uri.toString()

        webView.webViewClient = WebViewClient()

        //This will load the url of the website
        webView.loadUrl(url)

        //This will enable the javascript settings, it can also allow xss vulnerabilities
        webView.settings.javaScriptEnabled = true

        //If you want to enable zoom feature
        webView.settings.setSupportZoom(true)

        back2.setOnClickListener {
            finish()
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}