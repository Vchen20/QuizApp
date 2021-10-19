package com.example.quizapp

data class Question(
    var question: String,
    var correctAnswer: String,
    var incorrectAnswer1: String,
    var incorrectAnswer2: String,
    var incorrectAnswer3: String,
){
}