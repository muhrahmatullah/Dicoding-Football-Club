package com.rahmat.app.footballclub.rest

import com.rahmat.app.footballclub.entity.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by muhrahmatullah on 01/09/18.
 */
interface FootballRest {

    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("searchevents.php")
    fun searchMatches(@Query("e") query: String?) : Flowable<SearchedMatches>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<Teams>

    @GET("searchteams.php")
    fun getTeamBySearch(@Query("t") query: String) : Flowable<Teams>

    @GET("lookup_all_teams.php")
    fun getAllTeam(@Query("id") id:String) : Flowable<Teams>

    @GET("lookupevent.php")
    fun getEventById(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("lookup_all_players.php")
    fun getAllPlayers(@Query("id") id:String?) : Flowable<FootballPlayer>

    @GET("lookupplayer.php")
    fun getPlayerDetail(@Query("id") id:String?) : Flowable<PlayerDetail>

}