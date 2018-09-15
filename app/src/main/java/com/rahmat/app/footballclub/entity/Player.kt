package com.rahmat.app.footballclub.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    @SerializedName("dateBorn")
    var dateBorn: String?,
    @SerializedName("dateSigned")
    var dateSigned: String?,
    @SerializedName("idPlayer")
    var idPlayer: String,
    @SerializedName("idPlayerManager")
    var idPlayerManager: String?,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String?,
    @SerializedName("idTeam")
    var idTeam: String?,
    @SerializedName("intLoved")
    var intLoved: String?,
    @SerializedName("intSoccerXMLTeamID")
    var intSoccerXMLTeamID: String?,
    @SerializedName("strBanner")
    var strBanner: String?,
    @SerializedName("strBirthLocation")
    var strBirthLocation: String?,
    @SerializedName("strCollege")
    var strCollege: String?,
    @SerializedName("strCutout")
    var strCutout: String?,
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
    @SerializedName("strFacebook")
    var strFacebook: String?,
    @SerializedName("strFanart1")
    var strFanart1: String?,
    @SerializedName("strFanart2")
    var strFanart2: String?,
    @SerializedName("strFanart3")
    var strFanart3: String?,
    @SerializedName("strFanart4")
    var strFanart4: String?,
    @SerializedName("strGender")
    var strGender: String?,
    @SerializedName("strHeight")
    var strHeight: String?,
    @SerializedName("strInstagram")
    var strInstagram: String?,
    @SerializedName("strLocked")
    var strLocked: String?,
    @SerializedName("strNationality")
    var strNationality: String?,
    @SerializedName("strPlayer")
    var strPlayer: String?,
    @SerializedName("strPosition")
    var strPosition: String?,
    @SerializedName("strSigning")
    var strSigning: String?,
    @SerializedName("strSport")
    var strSport: String?,
    @SerializedName("strTeam")
    var strTeam: String?,
    @SerializedName("strThumb")
    var strThumb: String?,
    @SerializedName("strTwitter")
    var strTwitter: String?,
    @SerializedName("strWage")
    var strWage: String?,
    @SerializedName("strWebsite")
    var strWebsite: String?,
    @SerializedName("strWeight")
    var strWeight: String?,
    @SerializedName("strYoutube")
    var strYoutube: String?
): Parcelable
