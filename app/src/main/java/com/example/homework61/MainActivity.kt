package com.example.homework61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imageList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        addURL()
        showImage()
    }

    private fun setData(){
        imageList.add("https://i.pinimg.com/originals/0c/41/a5/0c41a5799be1c33ba65538a6ecf47553.jpg")
        imageList.add("https://clipartix.com/wp-content/uploads/2016/09/Cartoon-clipart-images-free-clipart-images-2.jpg")
        imageList.add("https://assets1.cbsnewsstatic.com/hub/i/r/2010/12/03/79ed9c0e-a644-11e2-a3f0-029118418759/thumbnail/640x480/eb16f6dc7042455d5f13675803aed687/365073.jpg")
        imageList.add("https://cdn.pixabay.com/photo/2013/07/13/13/14/tiger-160601__340.png")
        imageList.add("https://bcdbimages.s3.amazonaws.com/warner/daffy.jpg")
    }

    private fun addURL(){
        binding.btnSubmit.setOnClickListener {
            if(binding.etUrl.text.isNotEmpty()){
                imageList.add(binding.etUrl.text.toString())
                binding.etUrl.text.clear()
            }
        }
    }

    private fun showImage(){
        binding.btnRandom.setOnClickListener {
            Glide.with(this).load(imageList.random()).into(binding.ivMain)
        }
    }
}