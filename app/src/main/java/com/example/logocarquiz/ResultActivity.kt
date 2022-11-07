package com.example.logocarquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logocarquiz.data.Constants
import com.example.logocarquiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra(Constants.name)
        val score = intent.getStringExtra(Constants.score)
        val totalquestion = intent.getStringExtra("total size")

        binding.apply {
            "$userName siz".also { congo.text = it }
            "$score / $totalquestion \nsheshtin'iz".also { tvScore.text = it }
            btnExit.setOnClickListener {
                finish()
            }
        }
    }
}