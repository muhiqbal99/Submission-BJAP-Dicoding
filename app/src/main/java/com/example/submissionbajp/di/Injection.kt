package com.example.submissionbajp.di

import android.content.Context
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.LocalDataSource
import com.example.submissionbajp.data.source.local.room.ItemDatabase
import com.example.submissionbajp.data.source.remote.RemoteDataSource
import com.example.submissionbajp.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ItemRepository {

        val database = ItemDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return ItemRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}