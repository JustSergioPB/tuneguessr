package com.example.tuneguessr.data.models.game

import com.example.tuneguessr.data.models.player.Player
import com.example.tuneguessr.data.models.playlist.Playlist

abstract class Game(host: Player, val playlist: Playlist) {
    protected var status: GameStatus = GameStatus.Waiting
    protected val playerStatus: MutableList<PlayerStatus>
    private val questions: List<Question>

    init {
        playerStatus = arrayListOf(PlayerStatus(Player(
            host.email,
            host.nickname,
            true
        ), Score(), false))
        questions = arrayListOf()
    }

    abstract fun abandon(player: Player)

    fun answer(answer: Answer){
        if(status != GameStatus.Playing){
            throw Error("In order to answer the game must be playing")
        }

        val playerStatus = playerStatus.firstOrNull { it.player.nickname == answer.player.nickname}
            ?: throw Error("Player not found")

        if(answer.questionIndex == 10){
            playerStatus.isFinished = true
        }

        if(questions[answer.questionIndex].answer == answer.option){
            playerStatus.score.increment()
        }

        val everyOneFinished = this.playerStatus.all { it.isFinished }

        if(everyOneFinished){
            status = GameStatus.Finished
        }
    }
}