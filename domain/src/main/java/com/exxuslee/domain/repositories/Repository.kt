package com.exxuslee.domain.repositories

import com.exxuslee.domain.model.Player
import com.exxuslee.domain.utils.Result

interface Repository {
    suspend fun loadPlayer(name: String): Result<Player>
    suspend fun savePlayer(player: Player)
    suspend fun updatePlayer(player: Player)
    suspend fun players():Result<List<Player>>
}