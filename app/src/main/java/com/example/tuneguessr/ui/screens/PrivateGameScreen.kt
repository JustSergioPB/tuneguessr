package com.example.tuneguessr.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.SportsMma
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuneguessr.R
import com.example.tuneguessr.data.models.game.PrivateGame

@Composable
fun PrivateGamesScreen(
    onJoinSubmit: (PrivateGame) -> Unit, onGoBackClick: () -> Unit, modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Outlined.SportsMma,
                contentDescription = stringResource(id = R.string.public_game),
                modifier = Modifier.size(126.dp)
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Unirse a partida privada",
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.code)) },
                placeholder = { Text(stringResource(R.string.code_placeholder)) },
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.password)) },
                placeholder = { Text(stringResource(R.string.password_placeholder)) },
            )
            ExtendedFloatingActionButton(
                onClick = { onGoBackClick() },
                icon = { Icon(Icons.Outlined.Login, stringResource(R.string.join)) },
                text = { Text(text = stringResource(R.string.join)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        ExtendedFloatingActionButton(
            onClick = { onGoBackClick() },
            icon = { Icon(Icons.Outlined.ArrowBack, "Extended floating action button.") },
            text = { Text(text = stringResource(R.string.back)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
