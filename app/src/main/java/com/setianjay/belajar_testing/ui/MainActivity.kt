package com.setianjay.belajar_testing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.setianjay.belajar_testing.R
import com.setianjay.belajar_testing.ViewUtil.show
import com.setianjay.belajar_testing.databinding.ActivityMainBinding
import com.setianjay.belajar_testing.model.Cuboid

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cuboid: Cuboid
    private val viewModel by viewModels<MainViewModel>() {
        MainViewModelFactory(cuboid)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.btnCalculate.setOnClickListener(this)
        binding.btnVolume.setOnClickListener(this)
        binding.btnCircumference.setOnClickListener(this)
        binding.btnArea.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_calculate -> {
                val side: String = binding.edtSide.text.toString()
                if(side.isEmpty()){
                    binding.edtSide.error = "Field is required"
                    return
                }
                cuboid = Cuboid(side.toInt())
                btnState(1)
            }
            R.id.btn_volume -> {
                viewModel.volume()
                btnState(0)
            }
            R.id.btn_circumference -> {
                viewModel.circumference()
                btnState(0)
            }
            R.id.btn_area -> {
                viewModel.area()
                btnState(0)
            }
        }

        binding.tvResult.text = viewModel.getResult().toString()
    }

    private fun btnState(id: Int) {
        when (id) {
            1 -> {
                binding.apply {
                    btnCalculate.show(false)
                    containerSpecificResult.show(true)

                }
            }
            else -> {
                binding.apply {
                    btnCalculate.show(true)
                    containerSpecificResult.show(false)
                }
            }
        }
    }
}