package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player

data class PlayerStatus(
    val player: Player,
    val score: Score,
    var isFinished: Boolean
)
