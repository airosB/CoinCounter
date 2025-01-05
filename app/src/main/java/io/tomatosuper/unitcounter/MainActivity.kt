package io.tomatosuper.coincounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.tomatosuper.coincounter.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 初期カウントの表示
        updateCountDisplay()

        // 各ボタンのクリックリスナーを設定
        binding.buttonIncrement.setOnClickListener { incrementCount(1) }
        binding.buttonIncrement5.setOnClickListener { incrementCount(5) }
        binding.buttonIncrement10.setOnClickListener { incrementCount(10) }
        binding.buttonIncrement50.setOnClickListener { incrementCount(50) }
        binding.buttonIncrement100.setOnClickListener { incrementCount(100) }
        binding.buttonIncrement500.setOnClickListener { incrementCount(500) }
        binding.buttonReset.setOnClickListener { resetCount() }
    }

    private fun incrementCount(value: Int) {
        count += value
        updateCountDisplay()
    }

    private fun resetCount() {
        count = 0
        updateCountDisplay()
    }

    private fun updateCountDisplay() {
        binding.textViewCount.text = count.toString()
    }
}
