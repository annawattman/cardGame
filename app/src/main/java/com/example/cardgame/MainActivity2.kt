package com.example.cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    lateinit var randomCard: ImageView
    lateinit var higherBtn: Button
    lateinit var lowerBtn: Button
    lateinit var pointsTextView: TextView

    lateinit var currentCard: Card
    lateinit var lastCard: Card

    lateinit var cardImages: MutableList<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        pointsTextView = findViewById(R.id.points)
        randomCard = findViewById(R.id.randomCard)
        higherBtn = findViewById(R.id.higherBtn)
        lowerBtn = findViewById(R.id.lowerBtn)

        cardImages = mutableListOf()

        val card0 = Card(R.drawable.number0, 0)
        val card1 = Card(R.drawable.number1, 1)
        val card2 = Card(R.drawable.number2, 2)
        val card3 = Card(R.drawable.number3, 3)
        val card4 = Card(R.drawable.number4, 4)
        val card5 = Card(R.drawable.number5, 5)
        val card6 = Card(R.drawable.number6, 6)
        val card7 = Card(R.drawable.number7, 7)
        val card8 = Card(R.drawable.number8, 8)
        val card9 = Card(R.drawable.number9, 9)
        val card10 = Card(R.drawable.number10, 10)

        cardImages.add(card0)
        cardImages.add(card1)
        cardImages.add(card2)
        cardImages.add(card3)
        cardImages.add(card4)
        cardImages.add(card5)
        cardImages.add(card6)
        cardImages.add(card7)
        cardImages.add(card8)
        cardImages.add(card9)
        cardImages.add(card10)

        currentCard = cardImages[Random.nextInt(cardImages.size)]
        lastCard = currentCard

        var points : Int = 0

        higherBtn.setOnClickListener {
           if (randomCardHigher()) {
               points += 10
               pointsTextView.text = points.toString()
           } else {
               val intent = Intent(this, endpage::class.java)
               intent.putExtra("points", points);
               startActivity(intent)
           }
        }
        lowerBtn.setOnClickListener {
           if (randomCardLower()){
                points+= 10
                pointsTextView.text = points.toString()
           } else {
               val intent = Intent(this, endpage::class.java)
               intent.putExtra("points", points);
               startActivity(intent)
           }
        }
    }

    fun randomCardHigher(): Boolean {
        val random = Random
        lastCard = currentCard
        currentCard = cardImages[random.nextInt(cardImages.size)]
        var drawableId = this.resources.getIdentifier("number${currentCard.value}", "drawable", this.packageName)
        Log.d("randomCardHigher","drawableId= $drawableId")
        Log.d("randomCardHigher","currentCard= ${currentCard.value}")
        randomCard.setImageResource(drawableId)
        return lastCard.value < currentCard.value
    }

    fun randomCardLower(): Boolean {
        val random = Random
        lastCard = currentCard
        currentCard = cardImages[random.nextInt(cardImages.size)]
        var drawableId = this.resources.getIdentifier("number${currentCard.value}", "drawable", this.packageName)
        Log.d("randomCardLower","drawableId= $drawableId")
        Log.d("randomCardLower","currentCard= ${currentCard.value}")
        randomCard.setImageResource(drawableId)
        return lastCard.value > currentCard.value
    }
}
