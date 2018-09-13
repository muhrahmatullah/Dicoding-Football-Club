package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.rest.FootballRest

/**
 * Created by muhrahmatullah on 13/09/18.
 */
class PlayersRepositoryImpl(private val footballRest: FootballRest): PlayersRepository {

    override fun getAllPlayers(teamId: String?) = footballRest.getAllPlayers(teamId)

    override fun getPlayerDetail(playerId: String?) = footballRest.getPlayerDetail(playerId)
}