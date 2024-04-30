package com.example.tuneguessr.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tuneguessr.data.models.game.Game
import com.example.tuneguessr.data.models.game.GameType
import com.example.tuneguessr.data.models.playlist.Playlist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameState(null))
    val uiState = _uiState.asStateFlow()

    fun setType(gameType: GameType) {

    }

    fun setPassword(password: String?) {}

    fun setPlaylist(playlist: Playlist) {}

    fun create() {}

    fun join(game: Game) {}

    fun reset() {}

}

data class GameState(
    val data: Game?,
    val loading: Boolean = false
)