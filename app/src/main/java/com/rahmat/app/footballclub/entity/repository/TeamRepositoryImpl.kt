package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.Teams
import com.rahmat.app.footballclub.rest.FootballRest
import io.reactivex.Flowable

/**
 * Created by muhrahmatullah on 10/09/18.
 */
class TeamRepositoryImpl(val footballRest: FootballRest) : TeamRepository{

    override fun getTeams(id: String): Flowable<Teams> = footballRest.getAllTeam(id)
    override fun getTeamsDetail(id: String): Flowable<Teams> = footballRest.getTeam(id)

}