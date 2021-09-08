package com.example.submissionbajp.data.source.remote

import android.content.ContentValues.TAG
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.data.source.remote.response.MovieResponse
import com.example.submissionbajp.data.source.remote.response.TvShowResponse
import com.example.submissionbajp.service.RetrofitInstance
import com.example.submissionbajp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    private var handler = Handler(Looper.getMainLooper())

    fun getMovie(getMovieCallback: GetMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            RetrofitInstance.apiService.getMovie().enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>,
                ) {
                    response.body()?.results?.let { getMovieCallback.onResponse(it) }
                    EspressoIdlingResource.decrement()
                }
            })
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieDetail(id: Int, getMovieDetailCallback: GetMovieDetailCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            RetrofitInstance.apiService.getMovieDetails(id)
                .enqueue(object : Callback<Movie> {
                    override fun onFailure(call: Call<Movie>, t: Throwable) {
                        Log.d(TAG, t.printStackTrace().toString())
                    }

                    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                        getMovieDetailCallback.onResponse(response.body()!!)
                        EspressoIdlingResource.decrement()
                    }
                })
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShow(getTvShowCallback: GetTvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            RetrofitInstance.apiService.getTvShow().enqueue(object : Callback<TvShowResponse> {
                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>,
                ) {
                    response.body()?.results?.let { getTvShowCallback.onResponse(it) }
                    EspressoIdlingResource.decrement()
                }

            })
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShowDetail(
        id: Int,
        getTvShowDetailCallback: GetTvShowDetailCallback,
    ) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            RetrofitInstance.apiService.getTvShowDetails(id)
                .enqueue(object : Callback<TvShow> {
                    override fun onFailure(call: Call<TvShow>, t: Throwable) {
                        Log.d(TAG, t.printStackTrace().toString())
                    }

                    override fun onResponse(
                        call: Call<TvShow>,
                        response: Response<TvShow>,
                    ) {
                        getTvShowDetailCallback.onResponse(response.body()!!)
                        EspressoIdlingResource.decrement()
                    }
                })
        }, SERVICE_LATENCY_IN_MILLIS)

    }

    interface GetMovieCallback {
        fun onResponse(movieResponse: List<Movie>)
    }

    interface GetTvShowCallback {
        fun onResponse(tvShowResponse: List<TvShow>)
    }

    interface GetMovieDetailCallback {
        fun onResponse(movieDetailResponse: Movie)
    }

    interface GetTvShowDetailCallback {
        fun onResponse(tvShowDetailResponse: TvShow)
    }

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
}