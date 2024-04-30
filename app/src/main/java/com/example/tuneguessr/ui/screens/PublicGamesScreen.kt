package com.example.tuneguessr.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tuneguessr.R
import com.example.tuneguessr.data.models.game.PublicGame
import com.example.tuneguessr.ui.components.PublicGameCard
import com.example.tuneguessr.ui.viewmodels.PublicGamesViewModel

@Composable
fun PublicGamesScreen(
    onJoinSubmit: (PublicGame) -> Unit,
    onGoBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    publicGamesViewModel: PublicGamesViewModel = PublicGamesViewModel(),
) {
    val uiState by publicGamesViewModel.uiState.collectAsState()

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            if (uiState.loading) {
                LoadingState()
            } else {
                if (uiState.data != null) {
                    if (uiState.data!!.isEmpty()) {
                        EmptyState(onClick = {})
                    } else {
                        PublicGamesList(uiState.data!!, onJoinSubmit = { onJoinSubmit(it) })
                    }
                } else {
                    ErrorState()
                }
            }
        }
        ExtendedFloatingActionButton(
            onClick = { onGoBackClick() },
            icon = { Icon(Icons.Outlined.ArrowBack, stringResource(R.string.back)) },
            text = { Text(text = stringResource(R.string.back)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun EmptyState(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.no_available_public_games),
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.create_public_game_cta),
            modifier = Modifier.padding(32.dp)
        )
        ExtendedFloatingActionButton(
            onClick = { onClick() },
            icon = { Icon(Icons.Outlined.Add, stringResource(R.string.create)) },
            text = { Text(text = stringResource(R.string.create)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LoadingState() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.loading), modifier = Modifier.padding(16.dp)
        )
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ErrorState() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.something_broke), modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.try_again_later), modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun PublicGamesList(publicGames: List<PublicGame>, onJoinSubmit: (PublicGame) -> Unit) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        publicGames.map {
            PublicGameCard(game = it, onJoinSubmit = { onJoinSubmit(it) })
        }
    }
}