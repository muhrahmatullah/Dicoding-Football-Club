package com.rahmat.app.footballclub.feature.detail

import com.rahmat.app.footballclub.entity.Team

/**
 * Created by muhrahmatullah on 01/09/18.
 */
interface DetailContract {

    interface View{
        fun displayTeamBadgeHome(team: Team)
        fun displayTeamBadgeAway(team: Team)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
    }
}