package com.example.tuneguessr.data.models.playlist

data class PlaylistQuery (
    val page: Int,
    val pageSize: Int,
    val genre: List<String>?
)