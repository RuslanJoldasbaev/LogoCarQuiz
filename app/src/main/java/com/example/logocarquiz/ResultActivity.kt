package com.example.logocarquiz

import android.content.Intent
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
            if(score == "10") {
                tvImage.setImageResource(R.drawable.cup)
            }
            "$userName siz".also { congo.text = it }
            "$score / $totalquestion \n sheshtin'iz".also { tvScore.text = it }
            btnNew.setOnClickListener {
                val intent = Intent(this@ResultActivity, StartActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnExit.setOnClickListener {
                finish()
            }
        }
    }
}