package com.example.logocarquiz

import android.content.Context
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

        val sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE)
        val score = intent.getIntExtra("result", -1)
        val totalquestion = intent.getIntExtra("total size", -1)


        val name: String = sharedPreferences.getString("username", "") ?: "Unknown"
        binding.apply {
            if (score == 10) {
                tvImage.setImageResource(R.drawable.cup)
            }
            congo.text = getString(R.string.result_text, name)
            "$score / $totalquestion \n sheshtin'iz".also { tvScore.text = it }
            btnNew.setOnClickListener {
                val intent = Intent(this@ResultActivity, GameActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnExit.setOnClickListener {
                finish()
            }
        }
    }
}