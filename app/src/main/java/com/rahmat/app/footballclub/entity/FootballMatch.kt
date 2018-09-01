package com.rahmat.app.footballclub.entity

import com.google.gson.annotations.SerializedName
import com.rahmat.app.footballclub.entity.Event

data class FootballMatch (
        @SerializedName("events") var events: List<Event>)


