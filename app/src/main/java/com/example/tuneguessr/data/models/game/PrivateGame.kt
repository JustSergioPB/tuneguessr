package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player
import com.example.tuneguessr.data.models.playlist.Playlist

class PrivateGame(host: Player, playlist: Playlist, maxPlayers: Int, private val password: String): MultiplayerGame(host, playlist, maxPlayers) {
    fun join(player: Player, password: String){
        if(this.password != password){
            throw Error("Password mismatch")
        }
        addPlayer(player)
    }
}