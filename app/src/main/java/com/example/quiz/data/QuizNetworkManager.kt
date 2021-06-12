package com.example.quiz.data

import android.content.Context
import com.example.quiz.Response
import com.example.quiz.ResponseItem
import com.google.gson.Gson
import java.io.File
import java.io.FileReader
import java.io.IOException


object QuizNetworkManager {

    private const val FILENAME = "data.json"
    fun getQuizQuestions(context: Context): Response {
        val features: Array<ResponseItem>
        FileReader(getFileFromAssets(context, FILENAME).absolutePath).use { reader ->
            val gson = Gson()
            features = gson.fromJson(reader, Array<ResponseItem>::class.java)
        }
        return Response(features)
    }

    @Throws(IOException::class)
    fun getFileFromAssets(context: Context, fileName: String): File =
        File(context.cacheDir, fileName)
            .also {
                if (!it.exists()) {
                    it.outputStream().use { cache ->
                        context.assets.open(fileName).use { inputStream ->
                            inputStream.copyTo(cache)
                        }
                    }
                }
            }

}