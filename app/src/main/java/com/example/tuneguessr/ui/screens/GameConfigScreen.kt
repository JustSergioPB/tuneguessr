package com.example.tuneguessr.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tuneguessr.R
import com.example.tuneguessr.data.models.game.GameType
import com.example.tuneguessr.data.models.playlist.Playlist
import com.example.tuneguessr.ui.components.PlaylistCard
import com.example.tuneguessr.ui.viewmodels.GameConfigViewModel

@Composable
fun GameConfigScreen(
    modifier: Modifier = Modifier,
    gameConfigViewModel: GameConfigViewModel = GameConfigViewModel(),
    gameType: GameType,
    onGoBackClick: () -> Unit,
    onSubmitClick: (Playlist, String?) -> Unit
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            PlaylistCard(playlist = Playlist("Nombre", listOf(), listOf("Rap", "Trap"))) {}
        }
        if (gameType == GameType.Private) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.password)) },
                placeholder = { Text(stringResource(R.string.password_placeholder)) },
            )
        }
        ExtendedFloatingActionButton(
            onClick = { onGoBackClick() },
            icon = { Icon(Icons.Outlined.Games, stringResource(R.string.play)) },
            text = { Text(text = stringResource(R.string.play)) },
            modifier = Modifier.fillMaxWidth()
        )
        ExtendedFloatingActionButton(
            onClick = { onGoBackClick() },
            icon = { Icon(Icons.Outlined.ArrowBack, "Extended floating action button.") },
            text = { Text(text = stringResource(R.string.back)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}