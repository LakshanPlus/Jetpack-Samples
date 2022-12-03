package com.example.ktalksample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lazyLayout = findViewById<TextView>(R.id.lazy_layout)
        val pullToRefresh = findViewById<TextView>(R.id.pull_to_refresh)
        val variableFonts = findViewById<TextView>(R.id.variable_font)
        val drawCanvas = findViewById<TextView>(R.id.drew_canvas)


        lazyLayout.setOnClickListener {
            startActivity(Intent(this, LazyGrid::class.java))
        }

        pullToRefresh.setOnClickListener {
            startActivity(Intent(this, PullToRefresh::class.java))
        }

        variableFonts.setOnClickListener {
            startActivity(Intent(this, VariableFont::class.java))
        }

        drawCanvas.setOnClickListener {
            startActivity(Intent(this, DrawTextCanvas::class.java))
        }
    }
}