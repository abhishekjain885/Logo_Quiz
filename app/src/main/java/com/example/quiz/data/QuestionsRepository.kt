package com.example.quiz.data

import android.content.Context
import com.example.quiz.Response


class QuestionsRepository constructor(private val context: Context) {

    fun readData(): Response {
        return QuizNetworkManager.getQuizQuestions(context)
    }
}