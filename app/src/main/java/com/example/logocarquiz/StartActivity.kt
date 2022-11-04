package com.example.logocarquiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.logocarquiz.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("CapitalsSettings",Context.MODE_PRIVATE)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        binding.etName.addTextChangedListener {
            binding.tilName.isErrorEnabled = false
        }
        binding.btnStart.setOnClickListener {
            val name = binding.etName.text.toString()

            if (name.isEmpty() || name.isBlank()) {
                binding.tilName.error = getString(R.string.error_required)
            } else {
                sharedPreferences.edit().putString("username",name).apply()
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}