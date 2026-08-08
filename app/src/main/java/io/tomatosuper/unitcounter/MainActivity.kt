package io.tomatosuper.coincounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.tomatosuper.coincounter.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    // コイン種別ごとのカウント
    private var count1 = 0
    private var count5 = 0
    private var count10 = 0
    private var count50 = 0
    private var count100 = 0
    private var count500 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // エッジツーエッジ表示を有効化（下位互換性を確保）
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // システムバーのインセットを処理
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            windowInsets
        }

        // 画面回転やマルチウィンドウのリサイズで Activity が再生成されてもカウントを引き継ぐ
        savedInstanceState?.let(::restoreCounts)

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_TOTAL, count)
        outState.putInt(KEY_COUNT_1, count1)
        outState.putInt(KEY_COUNT_5, count5)
        outState.putInt(KEY_COUNT_10, count10)
        outState.putInt(KEY_COUNT_50, count50)
        outState.putInt(KEY_COUNT_100, count100)
        outState.putInt(KEY_COUNT_500, count500)
    }

    private fun restoreCounts(state: Bundle) {
        count = state.getInt(KEY_TOTAL)
        count1 = state.getInt(KEY_COUNT_1)
        count5 = state.getInt(KEY_COUNT_5)
        count10 = state.getInt(KEY_COUNT_10)
        count50 = state.getInt(KEY_COUNT_50)
        count100 = state.getInt(KEY_COUNT_100)
        count500 = state.getInt(KEY_COUNT_500)
    }

    private fun incrementCount(value: Int) {
        count += value
        when (value) {
            1 -> count1++
            5 -> count5++
            10 -> count10++
            50 -> count50++
            100 -> count100++
            500 -> count500++
        }
        updateCountDisplay()
    }

    private fun resetCount() {
        count = 0
        count1 = 0
        count5 = 0
        count10 = 0
        count50 = 0
        count100 = 0
        count500 = 0
        updateCountDisplay()
    }

    private fun updateCountDisplay() {
        binding.textViewCount.text = count.toString()
        binding.textViewCount1.text = "1円: ${count1}枚"
        binding.textViewCount5.text = "5円: ${count5}枚"
        binding.textViewCount10.text = "10円: ${count10}枚"
        binding.textViewCount50.text = "50円: ${count50}枚"
        binding.textViewCount100.text = "100円: ${count100}枚"
        binding.textViewCount500.text = "500円: ${count500}枚"
    }

    private companion object {
        const val KEY_TOTAL = "total"
        const val KEY_COUNT_1 = "count1"
        const val KEY_COUNT_5 = "count5"
        const val KEY_COUNT_10 = "count10"
        const val KEY_COUNT_50 = "count50"
        const val KEY_COUNT_100 = "count100"
        const val KEY_COUNT_500 = "count500"
    }
}
