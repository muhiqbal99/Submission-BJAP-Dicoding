package com.example.submissionbajp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.submissionbajp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovieList() {
        onView(withId(R.id.rv_items)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
        }
    }

    @Test
    fun loadTvShowList() {
        onView(withText("TVSHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_items)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
        }
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TVSHOWS")).perform(ViewActions.click())
        onView(withId(R.id.rv_items)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_items)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun loadFavorite() {
        onView(withText("MOVIE")).perform(ViewActions.click())
        onView(withId(R.id.rv_items)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.btn_fav)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withText("FAVORITE")).perform(ViewActions.click())
        onView(withId(R.id.rv_items)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_rating)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_release_date)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
        onView(withId(R.id.tv_overview)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun deleteFavorite() {
        onView(withText("FAVORITE")).perform(ViewActions.click())
        onView(withId(R.id.rv_items)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            ViewActions.click()))
        onView(withId(R.id.btn_fav)).perform(ViewActions.click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withText("FAVORITE")).perform(ViewActions.click())
        onView(withId(R.id.layout_error)).apply {
            check(matches(ViewMatchers.isDisplayed()))
        }
    }
}