package com.example.tuneguessr.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tuneguessr.data.models.playlist.Playlist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameConfigViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameConfigState(null))
    val uiState = _uiState.asStateFlow()
}

data class GameConfigState(
    val data: List<Playlist>?,
    val loading: Boolean = false
)