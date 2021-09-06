package com.example.submissionbajp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.submissionbajp.model.Movie
import com.example.submissionbajp.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<Movie> = DataDummy.getTvShow()
}