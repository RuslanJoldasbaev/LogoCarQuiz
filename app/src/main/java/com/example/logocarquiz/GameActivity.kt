package com.example.logocarquiz

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.logocarquiz.data.Constants
import com.example.logocarquiz.databinding.ActivityGameBinding
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val questions = Constants.provideQuestions()
    private var currentQuestionId = -1
    private var selectedAnswerId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentQuestionId = 0

        setQuestion()

        binding.apply {
            btnOptionOne.setOnClickListener {
                optionSelected(btnOptionOne)
                selectedAnswerId = 0
            }

            btnOptionTwo.setOnClickListener {
                optionSelected(btnOptionTwo)
                selectedAnswerId = 1
            }

            btnOptionThree.setOnClickListener {
                optionSelected(btnOptionThree)
                selectedAnswerId = 2
            }

            btnOptionFour.setOnClickListener {
                optionSelected(btnOptionFour)
                selectedAnswerId = 3
            }
            btnSubmit.setOnClickListener {
                btnOptionOne.isEnabled = true
                btnOptionTwo.isEnabled = true
                btnOptionThree.isEnabled = true
                btnOptionFour.isEnabled = true
                if (btnSubmit.text == getString(R.string.text_submit)) {
                    checkAnswer()
                } else {
                    currentQuestionId++
                    setQuestion()
                }
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val currentQuestion = questions[currentQuestionId]


        binding.apply {
            progressBar.progress = currentQuestionId+1
            progressBar.max = questions!!.size
            tvProgress.text="${currentQuestionId+1}"+"/"+"${questions!!.size}"
            tvQuestion.setImageResource(currentQuestion.question)
            btnOptionOne.text = currentQuestion.answers[0]
            btnOptionTwo.text = currentQuestion.answers[1]
            btnOptionThree.text = currentQuestion.answers[2]
            btnOptionFour.text = currentQuestion.answers[3]

            btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )


            btnSubmit.text = getString(R.string.text_submit)
        }
    }

    private fun optionSelected(button: Button) {
        binding.apply {
            btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
            btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.transparent)
            )
        }

        button.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.color_option_selected)
        )
    }

    private fun answerView(answer:Int,drawable:Int) {
        binding.apply {
            when(answer) {
                0 -> {
                    btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, drawable)
                    )
                }
                1 -> {
                    btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, drawable)
                    )
                }
                2 -> {
                    btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, drawable)
                    )
                }
                3 -> {
                    btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, drawable)
                    )
                }
            }
        }
    }

    private fun checkAnswer() {
        val currentQuestion = questions[currentQuestionId]

        if (selectedAnswerId == -1) {
            Snackbar.make(
                binding.btnSubmit,
                "Please, select option",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }
        binding.apply {

            val que = questions?.get(currentQuestionId)
            if(que!!.correctAnswerId != selectedAnswerId) {
                answerView(selectedAnswerId, R.color.color_error)
            }
            answerView(que.correctAnswerId,R.color.color_correct)
            btnSubmit.text = getString(R.string.continue_text)
            btnOptionOne.isEnabled = false
            btnOptionTwo.isEnabled = false
            btnOptionThree.isEnabled = false
            btnOptionFour.isEnabled = false
            selectedAnswerId =-1
        }
    }
}