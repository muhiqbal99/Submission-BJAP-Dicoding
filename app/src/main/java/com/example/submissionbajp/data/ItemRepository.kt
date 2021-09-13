package com.example.submissionbajp.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submissionbajp.data.source.local.LocalDataSource
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.data.source.remote.ApiResponse
import com.example.submissionbajp.data.source.remote.RemoteDataSource
import com.example.submissionbajp.data.source.remote.response.MovieResponse
import com.example.submissionbajp.data.source.remote.response.TvShowResponse
import com.example.submissionbajp.utils.AppExecutors
import com.example.submissionbajp.utils.DataMapper
import com.example.submissionbajp.vo.Resource

class ItemRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : ItemDataSource {

    companion object {
        @Volatile
        private var instance: ItemRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors,
        ): ItemRepository =
            instance ?: synchronized(this) {
                instance ?: ItemRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getMovie(): LiveData<Resource<List<ItemsEntity>>> {
        return object : NetworkBoundResource<List<ItemsEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<ItemsEntity>> =
                localDataSource.getMovieItem()

            override fun shouldFetch(data: List<ItemsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.movieMapResponsesToEntities(data)
                localDataSource.insertItems(movieList)
            }

        }.asLiveData()
    }

    override fun getTvShow(): LiveData<Resource<List<ItemsEntity>>> {
        return object :
            NetworkBoundResource<List<ItemsEntity>, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<ItemsEntity>> =
                localDataSource.getTvShowItem()

            override fun shouldFetch(data: List<ItemsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShow()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.tvMapResponsesToEntities(data)
                localDataSource.insertItems(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(id: Int): LiveData<Resource<ItemsEntity>> {
        return object : NetworkBoundResource<ItemsEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<ItemsEntity> =
                localDataSource.getMovieById(id)

            override fun shouldFetch(data: ItemsEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovieDetail(id)

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieDetail = DataMapper.movieIdMapResponsesToEntities(data)
                localDataSource.insertDetail(movieDetail)
            }

        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<ItemsEntity>> {
        return object : NetworkBoundResource<ItemsEntity, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<ItemsEntity> =
                localDataSource.getTvShowById(id)

            override fun shouldFetch(data: ItemsEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShowDetail(id)

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowDetail = DataMapper.tvIdMapResponsesToEntities(data)
                localDataSource.insertDetail(tvShowDetail)
            }
        }.asLiveData()
    }

    override fun getFavoriteItem(): LiveData<PagedList<ItemsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteItemList(), config).build()
    }


    override fun setFavorite(items: ItemsEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavorite(items, state) }
    }
}