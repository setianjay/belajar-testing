package com.setianjay.belajar_testing.model

data class Cuboid(private val side: Int){

    fun getVolume(): Int{
        return side * side * side
    }

    fun getCircumference(): Int{
        return 12 * side
    }

    fun getArea(): Int{
        return 6 * side * side
    }
}