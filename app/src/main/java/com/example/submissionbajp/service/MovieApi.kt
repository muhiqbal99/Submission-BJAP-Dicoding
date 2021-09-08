package com.example.submissionbajp.service

import com.example.submissionbajp.BuildConfig
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.data.source.remote.response.MovieResponse
import com.example.submissionbajp.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Call<Movie>

    @GET("discover/tv")
    fun getTvShow(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Call<TvShowResponse>

    @GET("tv/{tv_id}")
    fun getTvShowDetails(
        @Path("tv_id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Call<TvShow>
}