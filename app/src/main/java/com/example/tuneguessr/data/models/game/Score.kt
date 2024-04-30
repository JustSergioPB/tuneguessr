package com.example.tuneguessr.data.models.game

class Score {
    var value: Int = 0
        private set

    fun increment() {
        value += 1
    }

}