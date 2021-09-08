package com.example.submissionbajp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submissionbajp.ui.adapter.ViewPagerAdapter
import com.example.submissionbajp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = movieTabs[position]
        }.attach()

    }

    private val movieTabs = arrayOf(
        "Movie",
        "TvShows"
    )

}