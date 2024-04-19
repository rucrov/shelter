package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val modeBtn = findViewById<Button>(R.id.modeBtn)
        val showBasicView = findViewById<Button>(R.id.showBasicViewsActivity)
        val showNavigationView = findViewById<Button>(R.id.showNavigationActivity)

        modeBtn?.setOnClickListener() {
            var text = "Portrait"
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                text = "Landscape"
            }
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }

        showBasicView?.setOnClickListener() {
            val intent = Intent(this@MainActivity, BasicViewsActivity::class.java)
            startActivity(intent)
        }

        showNavigationView?.setOnClickListener() {
            val intent = Intent(this@MainActivity, NavidationDrawrerViewsActivity::class.java)
            startActivity(intent)
        }
    }

}