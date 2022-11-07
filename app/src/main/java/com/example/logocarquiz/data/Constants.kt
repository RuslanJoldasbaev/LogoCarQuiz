package com.example.logocarquiz.data

import com.example.logocarquiz.R

object Constants {

    const val name: String = "name"
    const val score: String = "score"

    fun provideQuestions(): List<Question> {
        val questions = mutableListOf<Question>()
        questions.add(
            Question(
                id = 0,
                question = R.drawable.shevrolet,
                answers = listOf("Chevrolet", "Volkswagen", "Volvo", "Mitsubishi"),
                correctAnswerId = 0
            )
        )
        questions.add(
            Question(
                id = 1,
                question = R.drawable.bmw,
                answers = listOf("Mitsubishi", "Volvo", "BMW", "Volkswagen"),
                correctAnswerId = 2
            )
        )
        questions.add(
            Question(
                id = 2,
                question = R.drawable.landrover,
                answers = listOf("Mercedes Benz", "LAND ROVER", "Volkswagen", "Mitsubishi"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id = 3,
                question = R.drawable.porsche,
                answers = listOf("Mitsubishi", "Mercedes Benz", "Ferrari", "Porsche"),
                correctAnswerId = 3
            )
        )
        questions.add(
            Question(
                id = 4,
                question = R.drawable.volkswagen,
                answers = listOf("Volvo", "Volkswagen", "BMW", "Chevrolet"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id = 5,
                question = R.drawable.mercedes,
                answers = listOf("Mitsubishi", "Ferrari", "Mercedes-Benz", "Kamaz"),
                correctAnswerId = 2
            )
        )
        questions.add(
            Question(
                id = 6,
                question = R.drawable.mitsubishi,
                answers = listOf("Volvo", "TOYOTA", "Kamaz", "Mitsubishi"),
                correctAnswerId = 3
            )
        )
        questions.add(
            Question(
                id = 7,
                question = R.drawable.toyota,
                answers = listOf("TOYOTA", "Volvo", "Ferrari", "Volkswagen"),
                correctAnswerId = 0
            )
        )
        questions.add(
            Question(
                id = 8,
                question = R.drawable.volvo,
                answers = listOf("Ford", "Volvo", "Volkswagen", "TOYOTA"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id = 9,
                question = R.drawable.ferrari,
                answers = listOf("Volvo", "Porsche", "Ferrari", "Ford"),
                correctAnswerId = 2
            )
        )
        return questions
    }
}