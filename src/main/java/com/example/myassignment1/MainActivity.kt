package com.example.myassignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.mapOf as mapOf1

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val editTextTimeOfDay = findViewById<EditText>(R.id.editTextTimeOfDay)
        val btnSuggestMeal = findViewById<Button>(R.id.btnSuggestMeal)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)

        //Define meal suggestions
        val mealSuggestions = mapOf1(
            "morning" to "Breakfast: Busy Morning? How about some Muesli and Greek Yogurt",
            "mid-morning" to "Snack: Feel a bit Hungry? Got you. Get some Fruit OR a hand full of nuts and maybe boil some eggs",
            "afternoon" to "Lunch: Make a Turkey Spicy Sandwich. Don't forget to drink water!! ",
            "mid-afternoon" to "Snack:Tea time.Sip the afternoon away with some cake and tea.",
            "dinner" to "Dinner: How about some Creamy Pasta with Garlic Bread and Hake Fish.",
            "after dinner" to " Dessert: A little late night snack? Get yourself some Ice Cream and add a topping of your choice"
        )
        //Button click for getting meal suggestion
        btnSuggestMeal.setOnClickListener {
            val userInput = editTextTimeOfDay.text.toString().trim().lowercase()

            if (mealSuggestions.containsKey(userInput)) {
                textViewSuggestion.text = mealSuggestions[userInput]
            } else {
                textViewSuggestion.text =
                    "Invalid input. Please enter a valid time (e.g., Morning, Afternoon)."
                Toast.makeText(this , "Enter a valid time of day!" , Toast.LENGTH_SHORT).show()
            }

        }
        //Reset button functionality
        btnReset.setOnClickListener {
            editTextTimeOfDay.text.clear()
            textViewSuggestion.text = ""
        }
    }
}


