package com.example.submissionbajp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.example.submissionbajp.utils.DataDummy
import com.example.submissionbajp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.getMovie()
    private val dummyTvShow = DataDummy.getTvShow()

    @get:Rule
    val activity = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }


    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovieList() {
        onView(withId(R.id.rv_movie)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
        }
    }

    @Test
    fun loadTvShowList() {
        onView(withText("TVSHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvShow)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
        }
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TVSHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_release_date)).check(matches(withText(dummyTvShow[0].releaseDate)))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_rating)).check(matches(withText(dummyTvShow[0].score.toString())))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShow[0].overview)))
        }
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_release_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_rating)).check(matches(withText(dummyMovie[0].score.toString())))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))
        }
    }
}