package com.example.quiz.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.Response
import com.example.quiz.data.QuestionsRepository
import com.example.quiz.data.model.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(private val repo: QuestionsRepository) : ViewModel() {

    private val state: LiveData<State> = MutableLiveData()

    private val quizdata: MutableLiveData<Response> = MutableLiveData()

    init {
        quizdata.value = repo.readData()
        state.value?.apply {
            questionsCount = quizdata.value?.response?.size ?: 0
            currentQuestion = 1
        }
    }

    fun getQuizData(): LiveData<Response> {
        return quizdata
    }

    fun getQuizState(): LiveData<State> {
        return state
    }


}