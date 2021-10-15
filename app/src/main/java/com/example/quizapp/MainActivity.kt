package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    lateinit var answerA: Button
    lateinit var answerB: Button
    lateinit var answerC: Button
    lateinit var answerD: Button
    lateinit var ask: TextView
    lateinit var start: Button
    lateinit var answers : Group
    var numCorrect = 0
    var quiz = arrayListOf<String>().toString()
    val Tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wireWidgets()
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(Tag, "onCreate : $jsonText")

        val gson = Gson()
        val type = object : TypeToken<List<Question>>() {}.type
        val questions = gson.fromJson<List<Question>>(jsonText, type)
        Log.d(Tag, "onCreate: \n$questions")
        answers.visibility = View.INVISIBLE
        start.setOnClickListener() {
            quiz = Quiz(questions).toString()
            ask.text = quest[0]
            answerA.text = quest[1]
            answerB.text = quest[2]
            answerC.text = quest[3]
            answerD.text = quest[4]
            answers.visibility = View.VISIBLE
            start.text = "Restart"
            start.visibility = View.INVISIBLE
        }



        answerA.setOnClickListener() {
            if (correctNum == 0) {
                numCorrect++
                Toast.makeText(this , "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show()
            }
            if (guess == 9) {
                gameOver()
                return@setOnClickListener
            }
            guess++
            quiz = Quiz(questions).toString()
            ask.text = quest[0]
            answerA.text = quest[1]
            answerB.text = quest[2]
            answerC.text = quest[3]
            answerD.text = quest[4]
        }

        answerB.setOnClickListener() {
            if (correctNum == 1) {
                numCorrect++
                Toast.makeText(this , "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show()
            }
            if (guess == 9) {
                gameOver()
                return@setOnClickListener
            }
            guess++
            quiz = Quiz(questions).toString()
            ask.text = quest[0]
            answerA.text = quest[1]
            answerB.text = quest[2]
            answerC.text = quest[3]
            answerD.text = quest[4]
        }

        answerC.setOnClickListener() {
            if (correctNum == 2) {
                numCorrect++
                Toast.makeText(this , "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show()
            }
            if (guess == 9) {
                gameOver()
                return@setOnClickListener
            }
            guess++
            quiz = Quiz(questions).toString()
            ask.text = quest[0]
            answerA.text = quest[1]
            answerB.text = quest[2]
            answerC.text = quest[3]
            answerD.text = quest[4]
        }

        answerD.setOnClickListener() {
            if (correctNum == 3) {
                numCorrect++
                Toast.makeText(this , "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "Wrong!", Toast.LENGTH_SHORT).show()
            }
            if (guess == 9) {
                gameOver()
                return@setOnClickListener
            }
            guess++
            quiz = Quiz(questions).toString()
            ask.text = quest[0]
            answerA.text = quest[1]
            answerB.text = quest[2]
            answerC.text = quest[3]
            answerD.text = quest[4]
        }
    }

    private fun gameOver() {
        answers.visibility = View.VISIBLE
        ask.text = "You got $numCorrect/10, pathetic"
        start.visibility = View.VISIBLE
        guess = 0
    }


    data class Question(
        var question: String,
        var correctAnswer: String,
        var incorrectAnswer1: String,
        var incorrectAnswer2: String,
        var incorrectAnswer3: String,
    ) {
    }


    private fun wireWidgets() {
        answerA = findViewById(R.id.button_main_a)
        answerB = findViewById(R.id.button_main_b)
        answerC = findViewById(R.id.button_main_c)
        answerD = findViewById(R.id.button_main_d)
        ask = findViewById(R.id.text_main_question)
        start = findViewById(R.id.button_main_start)
        answers = findViewById(R.id.group_main_answers)
    }
}