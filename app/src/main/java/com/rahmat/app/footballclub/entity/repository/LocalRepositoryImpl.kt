package com.rahmat.app.footballclub.entity.repository

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import com.rahmat.app.footballclub.entity.db.FavoriteMatch
import com.rahmat.app.footballclub.entity.db.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.delete

/**
 * Created by muhrahmatullah on 03/09/18.
 */
class LocalRepositoryImpl(private val context: Context) : LocalRepository {

    override fun checkFavorite(eventId: String): List<FavoriteMatch> {
        return context.database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE)
                    .whereArgs("(EVENT_ID = {id})",
                            "id" to eventId)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favorite
        }
    }


    override fun deleteData(eventId: String) {
        context.database.use{
            delete(FavoriteMatch.TABLE_FAVORITE, "(EVENT_ID = {id})",
                        "id" to eventId)
        }
    }

    override fun insertData(eventId: String, homeId: String, awayId: String) {
        context.database.use {
            insert(FavoriteMatch.TABLE_FAVORITE,
                    FavoriteMatch.EVENT_ID to eventId,
                    FavoriteMatch.HOME_TEAM_ID to homeId,
                    FavoriteMatch.AWAY_TEAM_ID to awayId)

        }
    }

    override fun getMatchFromDb(): List<FavoriteMatch> {
        lateinit var favoriteList :List<FavoriteMatch>
        context.database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favoriteList = favorite
        }
        return favoriteList
    }
}