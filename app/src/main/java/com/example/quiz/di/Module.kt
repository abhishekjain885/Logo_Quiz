package com.example.quiz.di

import android.content.Context
import com.example.quiz.data.QuestionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun getRepository( @ApplicationContext context: Context): QuestionsRepository {
        return QuestionsRepository(context)
    }
}