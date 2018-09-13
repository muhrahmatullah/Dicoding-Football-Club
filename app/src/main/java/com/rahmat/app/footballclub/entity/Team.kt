package com.rahmat.app.footballclub.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(

    @SerializedName("idLeague")
    var idLeague: String?,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String?,
    @SerializedName("idTeam")
    var idTeam: String,
    @SerializedName("intFormedYear")
    var intFormedYear: String?,
    @SerializedName("intLoved")
    var intLoved: String?,
    @SerializedName("intStadiumCapacity")
    var intStadiumCapacity: String?,
    @SerializedName("strAlternate")
    var strAlternate: String?,
    @SerializedName("strCountry")
    var strCountry: String?,
    @SerializedName("strDescriptionCN")
    var strDescriptionCN: String?,
    @SerializedName("strDescriptionDE")
    var strDescriptionDE: String?,
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String?,
    @SerializedName("strDescriptionES")
    var strDescriptionES: String?,
    @SerializedName("strDescriptionFR")
    var strDescriptionFR: String?,
    @SerializedName("strDescriptionHU")
    var strDescriptionHU: String?,
    @SerializedName("strDescriptionIL")
    var strDescriptionIL: String?,
    @SerializedName("strDescriptionIT")
    var strDescriptionIT: String?,
    @SerializedName("strDescriptionJP")
    var strDescriptionJP: String?,
    @SerializedName("strDescriptionNL")
    var strDescriptionNL: String?,
    @SerializedName("strDescriptionNO")
    var strDescriptionNO: String?,
    @SerializedName("strDescriptionPL")
    var strDescriptionPL: String?,
    @SerializedName("strDescriptionPT")
    var strDescriptionPT: String?,
    @SerializedName("strDescriptionRU")
    var strDescriptionRU: String?,
    @SerializedName("strDescriptionSE")
    var strDescriptionSE: String?,
    @SerializedName("strDivision")
    var strDivision: String?,
    @SerializedName("strFacebook")
    var strFacebook: String?,
    @SerializedName("strGender")
    var strGender: String?,
    @SerializedName("strInstagram")
    var strInstagram: String?,
    @SerializedName("strKeywords")
    var strKeywords: String?,
    @SerializedName("strLeague")
    var strLeague: String?,
    @SerializedName("strLocked")
    var strLocked: String?,
    @SerializedName("strManager")
    var strManager: String?,
    @SerializedName("strRSS")
    var strRSS: String?,
    @SerializedName("strSport")
    var strSport: String?,
    @SerializedName("strStadium")
    var strStadium: String?,
    @SerializedName("strStadiumDescription")
    var strStadiumDescription: String?,
    @SerializedName("strStadiumLocation")
    var strStadiumLocation: String?,
    @SerializedName("strStadiumThumb")
    var strStadiumThumb: String?,
    @SerializedName("strTeam")
    var strTeam: String?,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String,
    @SerializedName("strTeamBanner")
    var strTeamBanner: String?,
    @SerializedName("strTeamFanart1")
    var strTeamFanart1: String?,
    @SerializedName("strTeamFanart2")
    var strTeamFanart2: String?,
    @SerializedName("strTeamFanart3")
    var strTeamFanart3: String?,
    @SerializedName("strTeamFanart4")
    var strTeamFanart4: String?,
    @SerializedName("strTeamJersey")
    var strTeamJersey: String?,
    @SerializedName("strTeamLogo")
    var strTeamLogo: String?,
    @SerializedName("strTeamShort")
    var strTeamShort: String?,
    @SerializedName("strTwitter")
    var strTwitter: String?,
    @SerializedName("strWebsite")
    var strWebsite: String?,
    @SerializedName("strYoutube")
    var strYoutube: String?
) : Parcelable
