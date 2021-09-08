package com.example.submissionbajp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.data.source.remote.RemoteDataSource

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData)
            }
    }

    override fun getMovie(): LiveData<List<Movie>> {
        val movieResponses = MutableLiveData<List<Movie>>()
        remoteDataSource.getMovie(object : RemoteDataSource.GetMovieCallback {
            override fun onResponse(movieResponse: List<Movie>) {
                movieResponses.postValue(movieResponse)
            }
        })
        return movieResponses
    }

    override fun getDetailMovie(id: Int): LiveData<Movie> {
        val movieResponses = MutableLiveData<Movie>()
        remoteDataSource.getMovieDetail(id, object : RemoteDataSource.GetMovieDetailCallback {
            override fun onResponse(movieDetailResponse: Movie) {
                movieResponses.postValue(movieDetailResponse)
            }
        })
        return movieResponses
    }

    override fun getTvShow(): LiveData<List<TvShow>> {
        val tvShowResponses = MutableLiveData<List<TvShow>>()
        remoteDataSource.getTvShow(object : RemoteDataSource.GetTvShowCallback {
            override fun onResponse(tvShowResponse: List<TvShow>) {
                tvShowResponses.postValue(tvShowResponse)
            }
        })
        return tvShowResponses
    }

    override fun getDetailTvShow(id: Int): LiveData<TvShow> {
        val tvShowResponses = MutableLiveData<TvShow>()
        remoteDataSource.getTvShowDetail(id,
            object : RemoteDataSource.GetTvShowDetailCallback {
                override fun onResponse(tvShowDetailResponse: TvShow) {
                    tvShowResponses.postValue(tvShowDetailResponse)
                }
            })
        return tvShowResponses
    }
}