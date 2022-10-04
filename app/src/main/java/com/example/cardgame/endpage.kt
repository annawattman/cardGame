package com.example.cardgame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class endpage : AppCompatActivity() {
    lateinit var pointsTextView : TextView
    lateinit var endStartBtn : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.endpage)

        pointsTextView = findViewById(R.id.pointsTextView)
        endStartBtn = findViewById(R.id.endStartBtn)

        val points = intent.getIntExtra("points", 0)
        pointsTextView.text = points.toString()

    }
}

