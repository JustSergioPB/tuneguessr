package com.example.tuneguessr.data.models.game

data class GameQuery(
    val status: GameStatus?,
    val type: GameType?,
    val page: Int,
    val pageSize: Int
)
