package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player
import com.example.tuneguessr.data.models.playlist.Playlist

class PublicGame(host: Player, playlist: Playlist, maxPlayers: Int): MultiplayerGame(host, playlist, maxPlayers) {
    fun join(player: Player){
        addPlayer(player)
    }
}