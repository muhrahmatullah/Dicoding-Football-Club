package com.rahmat.app.footballclub.feature.players

import com.rahmat.app.footballclub.entity.Player

/**
 * Created by muhrahmatullah on 13/09/18.
 */
interface PlayersContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun displayPlayers(playerList: List<Player>)

    }
    interface Presenter{
        fun getAllPlayer(teamId: String?)
        fun onDestroy()
    }

}