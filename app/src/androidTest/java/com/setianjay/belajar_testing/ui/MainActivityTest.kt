package com.setianjay.belajar_testing.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.setianjay.belajar_testing.R
import com.setianjay.belajar_testing.model.Cuboid
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    private var dummySide: String = "5"
    private val dummyEmpty: String = ""
    private val dummyFieldEmpty: String = "Field is required"

    private val cuboid = Cuboid(dummySide.toInt())
    private val volume = cuboid.getVolume().toString()
    private val circumference = cuboid.getCircumference().toString()
    private val area = cuboid.getArea().toString()


    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertGetVolume(){
        //cari view dengan menggunakan id nya lalu lakukan aksi input dan rubah text nya lalu close keyboardnya
        onView(withId(R.id.edt_side)).perform(typeText(dummySide), closeSoftKeyboard())

        //cari view dengan menggunakan id nya lalu check apakah view sudah di tampilkan
        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()))
        //cari view dengan menggunakan id nya lalu lakukan aksi berdasarkan event click nya
        onView(withId(R.id.btn_calculate)).perform(click())

        onView(withId(R.id.btn_volume)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_volume)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        //cari view dengan menggunakan id nya lalu check apakah text dari view tersebut sama dengan resource yang di berikan
        onView(withId(R.id.tv_result)).check(matches(withText(volume)))
    }

    @Test
    fun assertGetCircumference(){
        onView(withId(R.id.edt_side)).perform(typeText(dummySide), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate)).perform(click())

        onView(withId(R.id.btn_circumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_circumference)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(circumference)))
    }

    @Test
    fun assertGetArea(){
        onView(withId(R.id.edt_side)).perform(typeText(dummySide), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate)).perform(click())

        onView(withId(R.id.btn_area)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_area)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(area)))
    }

    @Test
    fun assertEmptyInput(){
        onView(withId(R.id.edt_side)).perform(typeText(dummyEmpty), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate)).perform(click())

        onView(withId(R.id.edt_side)).check(matches(hasErrorText(dummyFieldEmpty)))

        onView(withId(R.id.edt_side)).perform(typeText(dummySide), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate)).perform(click())

        onView(withId(R.id.btn_volume)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_volume)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(volume)))
    }
}