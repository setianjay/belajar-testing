package com.setianjay.belajar_testing.ui

import com.setianjay.belajar_testing.model.Cuboid
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private lateinit var cuboid: Cuboid

    private var volume: Int = 0
    private var circumference: Int = 0
    private var area: Int = 0

    @Before
    fun init(){
        cuboid = Cuboid(10)
        viewModel = MainViewModel(cuboid)
    }

    @Test
    fun calculateVolume(){
        volume = cuboid.getVolume() //expected
        viewModel.volume() //actual
        assertEquals(volume, viewModel.getResult())
    }

    @Test
    fun calculateCircumference(){
        circumference = cuboid.getCircumference() //expected
        viewModel.circumference() //actual
        assertEquals(circumference, viewModel.getResult())
    }

    @Test
    fun calculateArea(){
        area = cuboid.getArea()
        viewModel.area() //actual
        assertEquals(area, viewModel.getResult())
    }
}