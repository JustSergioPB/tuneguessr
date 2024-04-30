package com.example.tuneguessr.data.repositories.player

import com.example.tuneguessr.data.models.player.Credentials

abstract class PlayerRepository {
    abstract fun login(credentials: Credentials)
}