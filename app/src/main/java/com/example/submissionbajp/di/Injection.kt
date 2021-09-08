package com.example.submissionbajp.di

import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.remote.RemoteDataSource

object Injection {
    fun movieRepository(): MovieRepository {
        val remoteRepository = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteRepository)
    }
}