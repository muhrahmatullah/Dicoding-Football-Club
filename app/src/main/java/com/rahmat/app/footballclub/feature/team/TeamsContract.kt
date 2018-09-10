package com.rahmat.app.footballclub.feature.team

/**
 * Created by muhrahmatullah on 10/09/18.
 */
interface TeamsContract {
    interface View{
        fun displayTeams()
        fun hideLoading()
        fun showLoading()

    }
    interface Presenter{
        fun getTeamData(leagueName: String)
    }
}