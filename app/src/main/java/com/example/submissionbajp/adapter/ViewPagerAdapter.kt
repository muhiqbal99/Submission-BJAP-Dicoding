package com.example.submissionbajp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.submissionbajp.ui.movie.MovieFragment
import com.example.submissionbajp.ui.tvshow.TvShowFragment

private const val NUM_TABS = 2

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MovieFragment()
            1 -> return TvShowFragment()
        }
        return Fragment()
    }
}