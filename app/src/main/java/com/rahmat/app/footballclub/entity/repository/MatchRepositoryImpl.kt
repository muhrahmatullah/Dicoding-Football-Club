package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.Teams
import com.rahmat.app.footballclub.rest.FootballRest
import io.reactivex.Flowable

/**
 * Created by muhrahmatullah on 01/09/18.
 */
class MatchRepositoryImpl(private val footballRest: FootballRest) : MatchRepository {

    override fun getEventById(id: String): Flowable<FootballMatch> = footballRest.getEventById(id)

    override fun getUpcomingMatch(id: String): Flowable<FootballMatch> = footballRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<FootballMatch> = footballRest.getLastmatch(id)
}