package com.example.submissionbajp.tvshow

import com.example.submissionbajp.ui.tvshow.TvShowViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun init() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShowSuccess() {
        val tvShowEntities = viewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}