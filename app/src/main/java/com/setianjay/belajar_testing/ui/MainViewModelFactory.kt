package com.setianjay.belajar_testing.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.setianjay.belajar_testing.model.Cuboid
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val cuboid: Cuboid): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(cuboid) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}