package com.example.tuneguessr.data.repositories.game

import com.example.tuneguessr.data.models.game.Game
import com.example.tuneguessr.data.models.game.GameQuery
import com.example.tuneguessr.data.models.game.PublicGame

abstract class GameRepository {
    abstract suspend fun create(game: Game): Game
    abstract suspend fun update(game: Game): Game
    abstract suspend fun get(id: String): Game
    abstract suspend fun search(query: GameQuery): List<Game>
    abstract suspend fun getAvailablePublicGames(): List<PublicGame>
}