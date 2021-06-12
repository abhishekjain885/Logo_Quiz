package com.example.quiz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quiz.R
import com.example.quiz.databinding.FragmentQuizScreenBinding
import com.example.quiz.presentation.adapter.GridSuggestAdapter
import com.example.quiz.presentation.viewmodel.QuizScreenViewModel
import com.example.quiz.util.constants.alphabets
import com.example.quiz.util.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizScreenFragment : Fragment() {

    var suggestSource: ArrayList<String> = ArrayList()

    lateinit var gridSuggestAdapter: GridSuggestAdapter

    private val viewModel: QuizScreenViewModel by viewModels()
    private lateinit var binding: FragmentQuizScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
    }

    private fun observeData() {
        viewModel.getQuizData().observe(this, {

            val responseItem =
                it.response?.get(viewModel.getQuizState().value?.currentQuestion ?: 0)
            binding.logoImage.loadImage(responseItem?.imgUrl ?: "")
            initSuggestSource(responseItem?.name ?: "")
        })
    }

    private fun initSuggestSource(name: String) {
        suggestSource.clear()
        for (i in name.toCharArray()) {
            suggestSource.add(i.toString())
        }
        val random = java.util.Random()

        for (i in name.length until name.length * 2) {
            suggestSource.add(alphabets[random.nextInt(alphabets.size)])
        }

        gridSuggestAdapter = GridSuggestAdapter(context, suggestSource)
        gridSuggestAdapter.notifyDataSetChanged()
        binding.answerView.adapter = gridSuggestAdapter


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_screen, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = QuizScreenFragment()
    }
}