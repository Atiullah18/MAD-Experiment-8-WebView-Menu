package com.example.webviewmenuapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "JAIN University"

        webView = findViewById(R.id.webView)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.jainuniversity.ac.in/")
    }

    override fun onSupportNavigateUp(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_home -> {
                webView.loadUrl("https://www.jainuniversity.ac.in/")
                return true
            }

            R.id.menu_google -> {
                webView.loadUrl("https://www.google.com/")
                return true
            }

            R.id.menu_about -> {
                Toast.makeText(
                    this,
                    "WebView Menu Application",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }

            R.id.menu_exit -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}