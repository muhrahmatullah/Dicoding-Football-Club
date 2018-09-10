package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.db.FavoriteMatch
import com.rahmat.app.footballclub.entity.db.FavoriteTeam

/**
 * Created by muhrahmatullah on 03/09/18.
 */
interface LocalRepository {

    fun getMatchFromDb() : List<FavoriteMatch>

    fun insertData(eventId: String, homeId: String, awayId: String)

    fun deleteData(eventId: String)

    fun checkFavorite(eventId: String) : List<FavoriteMatch>

    fun getTeamFromDb() : List<FavoriteTeam>

    fun insertTeamData(teamId: String, imgUrl: String)

    fun deleteTeamData(teamId: String)

    fun checkFavTeam(teamId: String) : List<FavoriteTeam>
}