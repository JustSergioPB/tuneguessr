package com.example.tuneguessr.ui.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuneguessr.data.models.game.PublicGame
import com.example.tuneguessr.data.repositories.game.GameFirestoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PublicGamesViewModel : ViewModel() {
    private val _repository = GameFirestoreRepository()
    private val _uiState = MutableStateFlow(
        PublicGamesState(
            null
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        search()
    }

    private fun search() {
        _uiState.update { current -> current.copy(loading = true) }
        viewModelScope.launch {
            val results = _repository.getAvailablePublicGames()
            _uiState.update { current -> current.copy(loading = false, data = results) }
        }
    }
}

data class PublicGamesState(
    val data: List<PublicGame>?,
    val loading: Boolean = false
)