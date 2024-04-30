package com.example.tuneguessr.data.repositories.game

import android.util.Log
import com.example.tuneguessr.data.models.game.Game
import com.example.tuneguessr.data.models.game.GameQuery
import com.example.tuneguessr.data.models.game.GameType
import com.example.tuneguessr.data.models.game.PublicGame
import com.example.tuneguessr.data.models.player.Player
import com.example.tuneguessr.data.models.playlist.Playlist
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class GameFirestoreRepository : GameRepository() {
    companion object {
        private const val COLLECTION_NAME = "games"
    }

    private val db: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    override suspend fun create(game: Game): Game {
        throw Error("Not implemented")
    }

    override suspend fun update(game: Game): Game {
        throw Error("Not implemented")
    }

    override suspend fun get(id: String): Game {
        throw Error("Not implemented")
    }

    override suspend fun search(query: GameQuery): List<Game> {
        throw Error("Not implemented")
    }

    override suspend fun getAvailablePublicGames(): List<PublicGame> {
        //val gamesRef = db.collection(COLLECTION_NAME).whereEqualTo("type", GameType.Public)
        //val snapshot = gamesRef.get().await()
        Log.d("Buenas", "Buenas")
        return arrayListOf(1, 2, 3, 4, 5).map { it ->
            val player = Player(
                "email",
                "nickName",
                true
            )
            val playlist = Playlist(
                "Playlist",
                listOf(),
                arrayListOf("Trap", "Rap", "Reagge")
            )
            PublicGame(
                player,
                playlist,
                3
            )
        }
    }
}
