package com.example.unitcounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unitcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 初期カウントの表示
        updateCountDisplay()

        // カウントアップボタンの処理
        binding.buttonIncrement.setOnClickListener {
            count++
            updateCountDisplay()
        }
    }

    private fun updateCountDisplay() {
        binding.textViewCount.text = count.toString()
    }
}
