package com.rahmat.app.footballclub.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by muhrahmatullah on 13/09/18.
 */
data class PlayerDetail(
        @SerializedName("players")
        var player: List<Player>)