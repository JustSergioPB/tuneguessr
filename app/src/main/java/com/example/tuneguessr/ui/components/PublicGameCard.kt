package com.example.tuneguessr.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuneguessr.R
import com.example.tuneguessr.data.models.game.PublicGame

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublicGameCard(game: PublicGame, onJoinSubmit: () -> Unit){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.MusicNote,
                    stringResource(R.string.join),
                    modifier = Modifier.size(36.dp)
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Nickname", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("adi9as-dase-54ma", fontWeight = FontWeight.Light)
                }
            }
            Column {
                Text(stringResource(R.string.genres), fontWeight = FontWeight.SemiBold)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    game.playlist.genres.map {
                        FilterChip(
                            selected = true,
                            onClick = { /*TODO*/ },
                            label = { Text(it) })
                    }
                }
            }
            ExtendedFloatingActionButton(
                onClick = { onJoinSubmit() },
                icon = { Icon(Icons.Outlined.Login, stringResource(R.string.join)) },
                text = { Text(text = stringResource(R.string.join)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}