package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.Teams
import io.reactivex.Flowable

/**
 * Created by muhrahmatullah on 01/09/18.
 */
interface MatchRepository {

    fun getFootballMatch(id : String) : Flowable<FootballMatch>

    fun getUpcomingMatch(id : String) : Flowable<FootballMatch>

    fun getEventById(id: String) : Flowable<FootballMatch>
}