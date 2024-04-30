package com.example.tuneguessr.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.SportsMma
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuneguessr.R
import com.example.tuneguessr.data.models.game.GameType
import com.example.tuneguessr.data.models.playlist.Playlist
import com.example.tuneguessr.ui.models.Action
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    onOptionSelected: (GameType, Action) -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedType by remember {
        mutableStateOf<GameType?>(null)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(64.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Outlined.MusicNote,
                contentDescription = stringResource(id = R.string.public_game),
                modifier = Modifier.size(126.dp)
            )
            Text(modifier = Modifier.padding(8.dp), text = "TuneGuessr", fontSize = 48.sp)
        }
        Column(verticalArrangement = Arrangement.spacedBy(64.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
                ExtendedFloatingActionButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        selectedType = GameType.Private
                        showBottomSheet = true
                    },
                    icon = {
                        Icon(
                            Icons.Outlined.SportsMma,
                            contentDescription = stringResource(id = R.string.public_game)
                        )
                    },
                    text = { Text(stringResource(R.string.private_game)) }
                )

                ExtendedFloatingActionButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        selectedType = GameType.Public
                        showBottomSheet = true
                     },
                    icon = {
                        Icon(
                            Icons.Outlined.Public,
                            contentDescription = stringResource(id = R.string.public_game),
                        )
                    },
                    text = { Text(stringResource(R.string.public_game)) }
                )
                ExtendedFloatingActionButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onOptionSelected(GameType.Private, Action.Create) },
                    icon = {
                        Icon(
                            Icons.Outlined.FitnessCenter,
                            contentDescription = stringResource(id = R.string.training_game)
                        )
                    },
                    text = { Text(stringResource(R.string.training_game)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FloatingActionButton(onClick = { onProfileClick() }) {
                    Icon(
                        Icons.Outlined.BarChart,
                        contentDescription = stringResource(id = R.string.public_game)
                    )
                }
                FloatingActionButton(onClick = { onLogoutClick() }) {
                    Icon(
                        Icons.Outlined.ExitToApp,
                        contentDescription = stringResource(id = R.string.public_game)
                    )
                }
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        JoinButton(gameType = selectedType, onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                                onOptionSelected(selectedType!!, Action.Join)
                            }
                        })
                        ExtendedFloatingActionButton(
                            onClick = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                    onOptionSelected(selectedType!!, Action.Create)
                                }
                            },
                            icon = { Icon(Icons.Outlined.Add, "Extended floating action button.") },
                            text = { Text(text = stringResource(R.string.create)) },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun JoinButton(gameType: GameType?, onClick:() -> Unit){
    var icon = Icons.Outlined.Login
    var text = stringResource(R.string.join)
    if(gameType == GameType.Public){
        icon = Icons.Outlined.Search
        text = stringResource(R.string.search)
    }
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = {
            Icon(
                icon,
                text
            )
        },
        text = { Text(text) },
        modifier = Modifier.fillMaxWidth()
    )
}