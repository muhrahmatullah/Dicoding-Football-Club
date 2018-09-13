package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.FootballPlayer
import com.rahmat.app.footballclub.entity.PlayerDetail
import io.reactivex.Flowable

/**
 * Created by muhrahmatullah on 13/09/18.
 */
interface PlayersRepository {

    fun getAllPlayers(teamId: String?) : Flowable<FootballPlayer>
    fun getPlayerDetail(playerId: String?) : Flowable<PlayerDetail>
}