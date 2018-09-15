package com.rahmat.app.footballclub.entity

import com.google.gson.annotations.SerializedName


data class FootballPlayer(
    @SerializedName("player")
    var player: List<Player>)

