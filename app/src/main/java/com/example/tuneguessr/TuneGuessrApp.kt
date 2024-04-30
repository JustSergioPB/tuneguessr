package com.example.tuneguessr

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tuneguessr.data.models.game.GameType
import com.example.tuneguessr.ui.models.Action
import com.example.tuneguessr.ui.screens.GameConfigScreen
import com.example.tuneguessr.ui.screens.GameLobbyScreen
import com.example.tuneguessr.ui.screens.PrivateGamesScreen
import com.example.tuneguessr.ui.screens.PublicGamesScreen
import com.example.tuneguessr.ui.screens.StartScreen
import com.example.tuneguessr.ui.viewmodels.GameViewModel

enum class TuneGuessrScreen {
    Start,
    PrivateGame,
    PublicGame,
    Lobby,
    Config
}

@Composable
fun TuneGuessrApp(
    viewModel: GameViewModel = GameViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TuneGuessrScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            composable(route = TuneGuessrScreen.Start.name) {
                StartScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    onOptionSelected = { type, action ->
                        viewModel.setType(type)
                        var nextScreen: String

                        nextScreen = when (type) {
                            GameType.Public -> TuneGuessrScreen.PublicGame.name
                            GameType.Private -> TuneGuessrScreen.PrivateGame.name
                            GameType.Training -> TuneGuessrScreen.Config.name
                        }

                        if(action == Action.Create){
                            nextScreen = TuneGuessrScreen.Config.name
                        }

                        navController.navigate(nextScreen)
                    },
                    onProfileClick = { /*TODO*/ },
                    onLogoutClick = { /*TODO*/ })
            }
            composable(route = TuneGuessrScreen.PrivateGame.name) {
                PrivateGamesScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    onJoinSubmit = { game -> viewModel.join(game) },
                    onGoBackClick = { goBackAndReset(viewModel, navController) })
            }
            composable(route = TuneGuessrScreen.PublicGame.name) {
                PublicGamesScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    onJoinSubmit = { game -> viewModel.join(game) },
                    onGoBackClick = { goBackAndReset(viewModel, navController) })
            }
            composable(route = TuneGuessrScreen.Config.name) {
                GameConfigScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    gameType = GameType.Public,
                    onGoBackClick = { goBackAndReset(viewModel, navController) },
                    onSubmitClick = { playlist, pwd ->
                        viewModel.setPlaylist(playlist)
                        viewModel.setPassword(pwd)
                        viewModel.create()
                    })
            }
            composable(route = TuneGuessrScreen.Lobby.name) {
                GameLobbyScreen()
            }
        }
    }
}

fun goBackAndReset(viewModel: GameViewModel, navController: NavHostController) {
    viewModel.reset()
    navController.popBackStack(TuneGuessrScreen.Start.name, inclusive = false)
}