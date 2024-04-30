package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player

data class Answer(
    val player: Player,
    val questionIndex: Int,
    val option: Int?
)
