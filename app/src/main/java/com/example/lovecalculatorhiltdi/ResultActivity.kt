package com.example.lovecalculatorhiltdi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculatorhiltdi.MainActivity.Companion.INTENT_FOR_RESULT
import com.example.lovecalculatorhiltdi.databinding.ActivityResultBinding
import com.example.lovecalculatorhiltdi.remote.LoveModel


class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var loveModel: LoveModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loveModel = intent.getSerializableExtra(INTENT_FOR_RESULT) as LoveModel
        binding.result.text = loveModel.percentage
    }

}