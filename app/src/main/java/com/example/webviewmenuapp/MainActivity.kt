package com.example.webviewmenuapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        setSupportActionBar(toolbar)

        // Open Images Fragment initially
        if (savedInstanceState == null) {
            openImages()
        }

        // Bottom Navigation
        bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_images -> {
                    openImages()
                    true
                }

                R.id.nav_webview -> {
                    openWebView()
                    true
                }

                else -> false
            }
        }
    }

    private fun openImages() {

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                ImagesFragment()
            )
            .commit()

        toolbar.title = "Images Fragment"
    }

    private fun openWebView() {

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                WebViewFragment()
            )
            .commit()

        toolbar.title = "WebView"
    }

    // Top-right menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menu_select_all -> {

                Toast.makeText(
                    this,
                    "All images selected",
                    Toast.LENGTH_SHORT
                ).show()

                return true
            }

            R.id.menu_share -> {

                Toast.makeText(
                    this,
                    "Images shared",
                    Toast.LENGTH_SHORT
                ).show()

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}