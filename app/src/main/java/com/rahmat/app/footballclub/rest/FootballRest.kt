package com.rahmat.app.footballclub.rest

import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.Teams
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

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<Teams>

    @GET("lookupevent.php")
    fun getEventById(@Query("id") id:String) : Flowable<FootballMatch>
}