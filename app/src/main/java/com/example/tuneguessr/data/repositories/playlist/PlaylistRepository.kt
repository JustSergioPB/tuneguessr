package com.example.tuneguessr.data.repositories.playlist

import com.example.tuneguessr.data.models.playlist.Playlist
import com.example.tuneguessr.data.models.playlist.PlaylistQuery

abstract class PlaylistRepository {
    abstract fun search(query: PlaylistQuery): List<Playlist>

}