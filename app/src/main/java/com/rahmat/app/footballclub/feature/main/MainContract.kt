package com.rahmat.app.footballclub.feature.main

import com.rahmat.app.footballclub.entity.Event

/**
 * Created by muhrahmatullah on 01/09/18.
 */
interface MainContract {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<Event>)
    }

    interface Presenter{
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }

}