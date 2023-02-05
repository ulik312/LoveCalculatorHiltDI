package com.example.lovecalculatorhiltdi.onboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculatorhiltdi.MainActivity
import com.example.lovecalculatorhiltdi.databinding.ActivityOnBoardBinding
import com.example.lovecalculatorhiltdi.local.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardBinding

    @Inject
    lateinit var pref : Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
    }

    private fun onClick() {
        pref.setOnBoardingSeen(false)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


    private fun initViewPager() {
        val adapter = onBoardAdapter(this, this::onClick)
        binding.viewPager.adapter = adapter
        val indicator = binding.dotsIndicator
        indicator.attachTo(binding.viewPager)
    }

}