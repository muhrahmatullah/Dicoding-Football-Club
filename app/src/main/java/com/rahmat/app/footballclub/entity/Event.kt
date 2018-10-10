package com.rahmat.app.footballclub.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class Event(
        @SerializedName("dateEvent") var dateEvent: Date?,
        @SerializedName("idAwayTeam") var idAwayTeam: String,
        @SerializedName("idEvent") var idEvent: String,
        @SerializedName("idHomeTeam") var idHomeTeam: String,
        @SerializedName("idLeague") var idLeague: String?,
        @SerializedName("idSoccerXML") var idSoccerXML: String?,
        @SerializedName("intAwayScore") var intAwayScore: String?,
        @SerializedName("intHomeScore") var intHomeScore: String?,
        @SerializedName("intRound") var intRound: String?,
        @SerializedName("strAwayFormation") var strAwayFormation: String?,
        @SerializedName("strAwayGoalDetails") var strAwayGoalDetails: String?,
        @SerializedName("strAwayLineupDefense") var strAwayLineupDefense: String?,
        @SerializedName("strAwayLineupForward") var strAwayLineupForward: String?,
        @SerializedName("strAwayLineupGoalkeeper") var strAwayLineupGoalkeeper: String?,
        @SerializedName("strAwayLineupMidfield") var strAwayLineupMidfield: String?,
        @SerializedName("strAwayLineupSubstitutes") var strAwayLineupSubstitutes: String?,
        @SerializedName("strAwayRedCards") var strAwayRedCards: String?,
        @SerializedName("strAwayTeam") var strAwayTeam: String?,
        @SerializedName("strAwayYellowCards") var strAwayYellowCards: String?,
        @SerializedName("strDate") var strDate: String?,
        @SerializedName("strEvent") var strEvent: String?,
        @SerializedName("strFilename") var strFilename: String?,
        @SerializedName("strHomeFormation") var strHomeFormation: String?,
        @SerializedName("strHomeGoalDetails") var strHomeGoalDetails: String?,
        @SerializedName("strHomeLineupDefense") var strHomeLineupDefense: String?,
        @SerializedName("strHomeLineupForward") var strHomeLineupForward: String?,
        @SerializedName("strHomeLineupGoalkeeper") var strHomeLineupGoalkeeper: String?,
        @SerializedName("strHomeLineupMidfield") var strHomeLineupMidfield: String?,
        @SerializedName("strHomeLineupSubstitutes") var strHomeLineupSubstitutes: String?,
        @SerializedName("strHomeRedCards") var strHomeRedCards: String?,
        @SerializedName("strHomeTeam") var strHomeTeam: String?,
        @SerializedName("strHomeYellowCards") var strHomeYellowCards: String?,
        @SerializedName("strLeague") var strLeague: String?,
        @SerializedName("strLocked") var strLocked: String?,
        @SerializedName("strSeason") var strSeason: String?,
        @SerializedName("strSport") var strSport: String?,
        @SerializedName("strTime") var strTime: String
):Parcelable
