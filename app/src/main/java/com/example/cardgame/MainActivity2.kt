package com.example.cardgame

import Card
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    lateinit var randomCard: ImageView
    lateinit var higherBtn: Button
    lateinit var lowerBtn: Button
    lateinit var currentCard: Card
    lateinit var lastCard: Card


    lateinit var cardImages: MutableList<Card>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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


        var points = 0
        randomCard = findViewById(R.id.randomCard)
        higherBtn = findViewById(R.id.higherBtn)
        lowerBtn = findViewById(R.id.lowerBtn)

        higherBtn.setOnClickListener {
           if (randomCardHigher()) {
               points++
           }
        }
        lowerBtn.setOnClickListener {
           if (randomCardLower())
               points++
        }
    }

    fun randomCardHigher(): Boolean {
        val random = Random
        lastCard = currentCard
        currentCard = cardImages[random.nextInt(cardImages.size)]
        var drawableId = this.resources.getIdentifier("card${currentCard.value}", "drawable", this.packageName)
        randomCard.setImageResource(drawableId)
        return lastCard.value < currentCard.value
    }

    fun randomCardLower(): Boolean {
        val random = Random
        lastCard = currentCard
        currentCard = cardImages[random.nextInt(cardImages.size)]
        var drawableId = this.resources.getIdentifier("card${currentCard.value}", "drawable", this.packageName)
        randomCard.setImageResource(drawableId)
        return lastCard.value > currentCard.value
    }
}
