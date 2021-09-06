package com.example.submissionbajp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.example.submissionbajp.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class TvShowViewModelTest {

    private val movieList = DataDummy.getMovie()
    private val tvShowList = DataDummy.getTvShow()

    @get:Rule
    val activity = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovieList() {
        onView(withId(R.id.rv_movie)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieList.size))
        }
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(movieList[0].title)))
        }
        onView(withId(R.id.tv_duration)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(movieList[0].duration)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(movieList[0].genre)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(movieList[0].releaseDate)))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(movieList[0].score)))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(movieList[0].overview)))
        }
    }

    @Test
    fun loadTvShowList() {
        onView(withText("TVSHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvShow)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowList.size))
        }
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TVSHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(tvShowList[0].title)))
        }
        onView(withId(R.id.tv_duration)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(tvShowList[0].duration)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(tvShowList[0].genre)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(tvShowList[0].releaseDate)))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(tvShowList[0].score)))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            check(ViewAssertions.matches(withText(tvShowList[0].overview)))
        }
    }
}