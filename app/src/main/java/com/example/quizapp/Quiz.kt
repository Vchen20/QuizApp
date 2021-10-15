package com.example.quizapp

import android.view.View

var guess = 0
var correctNum = 0
var quest = arrayListOf<String>()

class Quiz {
    constructor(questions: List<MainActivity.Question>)
    {
        quest = arrayListOf()
        quest.add("")
        quest.add("")
        quest.add("")
        quest.add("")
        quest.add("")
        correctNum = (Math.random()*4).toInt()
        if(correctNum == 0){
            quest[0] = questions[guess].question
            quest[1] = questions[guess].correctAnswer
            quest[2] = questions[guess].incorrectAnswer1
            quest[3] = questions[guess].incorrectAnswer2
            quest[4] = questions[guess].incorrectAnswer3
        }
        if (correctNum == 1){
            quest[0] = questions[guess].question
            quest[1] = questions[guess].incorrectAnswer3
            quest[2] = questions[guess].correctAnswer
            quest[3] = questions[guess].incorrectAnswer1
            quest[4] = questions[guess].incorrectAnswer2
        }
        if(correctNum == 2){
            quest[0] = questions[guess].question
            quest[1] = questions[guess].incorrectAnswer2
            quest[2] = questions[guess].incorrectAnswer3
            quest[3] = questions[guess].correctAnswer
            quest[4] = questions[guess].incorrectAnswer1
        }
        if(correctNum == 3){
            quest[0] = questions[guess].question
            quest[1] = questions[guess].incorrectAnswer1
            quest[2] = questions[guess].incorrectAnswer2
            quest[3] = questions[guess].incorrectAnswer3
            quest[4] = questions[guess].correctAnswer
        }
    }


}