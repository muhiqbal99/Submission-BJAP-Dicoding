package com.example.submissionbajp.utils

import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.data.source.remote.response.MovieResponse
import com.example.submissionbajp.data.source.remote.response.TvShowResponse

object DataMapper {
    fun movieMapResponsesToEntities(input: List<MovieResponse>): List<ItemsEntity> {
        val movieList = ArrayList<ItemsEntity>()
        input.map {
            val movie = ItemsEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                type = "movie"
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun tvMapResponsesToEntities(input: List<TvShowResponse>): List<ItemsEntity> {
        val tvShowList = ArrayList<ItemsEntity>()
        input.map {
            val tvshow = ItemsEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                type = "tvshow"
            )
            tvShowList.add(tvshow)
        }
        return tvShowList
    }

    fun movieIdMapResponsesToEntities(input: List<MovieResponse>): List<ItemsEntity> =
        input.map {
            ItemsEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                type = "movie"
            )
        }

    fun tvIdMapResponsesToEntities(input: List<TvShowResponse>): List<ItemsEntity> =
        input.map {
            ItemsEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                score = it.score,
                overview = it.overview,
                poster = it.poster,
                type = "movie"
            )
        }

}