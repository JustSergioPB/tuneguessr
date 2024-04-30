package com.example.tuneguessr.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tuneguessr.data.models.player.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameLobbyViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameLobbyState(null))
    val uiState = _uiState.asStateFlow()
}

data class GameLobbyState(
    val players: List<Player>?,
    val loading: Boolean = false
)