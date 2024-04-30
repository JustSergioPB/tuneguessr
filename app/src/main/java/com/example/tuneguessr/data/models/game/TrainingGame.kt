package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player
import com.example.tuneguessr.data.models.playlist.Playlist

class TrainingGame(host: Player, playlist: Playlist): Game(host, playlist) {
    override fun abandon(player: Player) {
        status = GameStatus.Finished
    }
}