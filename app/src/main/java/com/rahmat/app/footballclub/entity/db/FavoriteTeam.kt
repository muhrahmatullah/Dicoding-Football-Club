package com.rahmat.app.footballclub.entity.db

/**
 * Created by muhrahmatullah on 10/09/18.
 */
class FavoriteTeam(
        val id: Long?,
        val idTeam: String,
        val urlImage: String
){
    companion object {
        const val TEAM_TABLE: String = "TEAM_TABLE"
        const val ID: String = "ID_"
        const val TEAM_ID: String = "TEAM_ID"
        const val TEAM_IMAGE: String = "TEAM_IMAGE"
    }
}