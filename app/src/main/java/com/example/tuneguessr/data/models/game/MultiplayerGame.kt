package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player
import com.example.tuneguessr.data.models.playlist.Playlist

abstract class MultiplayerGame(host: Player, playlist: Playlist, private val maxPlayers: Int): Game(host, playlist) {
    override fun abandon(player: Player) {
        val playerStatus = this.playerStatus.firstOrNull {it.player.nickname == player.nickname}
            ?: throw Error("Player not found")

        this.playerStatus.remove(playerStatus)

        if(playerStatus.player.isHost || this.playerStatus.size == 0){
            status = GameStatus.Finished
        }
    }

    protected fun addPlayer(player: Player){
        if(status == GameStatus.Playing){
            throw Error("Cannot join playing party")
        }

        val status = this.playerStatus.firstOrNull {it.player.nickname == player.nickname}

        if(status != null) {
            throw Error("Player has already joined")
        }

        playerStatus.add(PlayerStatus(Player(player.email, player.nickname, false), Score(), false))

        if(playerStatus.size == maxPlayers){
            this.status = GameStatus.Playing
        }
    }
}