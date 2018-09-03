package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.db.FavoriteMatch

/**
 * Created by muhrahmatullah on 03/09/18.
 */
interface LocalRepository {

    fun getMatchFromDb() : List<FavoriteMatch>

    fun insertData(eventId: String, homeId: String, awayId: String)

    fun deleteData(eventId: String)

    fun checkFavorite(eventId: String) : List<FavoriteMatch>
}