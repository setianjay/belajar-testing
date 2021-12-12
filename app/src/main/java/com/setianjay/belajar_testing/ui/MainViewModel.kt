package com.setianjay.belajar_testing.ui

import androidx.lifecycle.ViewModel
import com.setianjay.belajar_testing.model.Cuboid

class MainViewModel(private val cuboid: Cuboid): ViewModel() {
    private var result: Int = 0

    fun volume(){
        result = cuboid.getVolume()
    }

    fun circumference(){
        result = cuboid.getCircumference()
    }

    fun area(){
        result = cuboid.getArea()
    }

    fun getResult(): Int{
        return result
    }
}