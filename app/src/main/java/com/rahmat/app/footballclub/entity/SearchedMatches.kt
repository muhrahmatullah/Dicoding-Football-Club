package com.rahmat.app.footballclub.entity

import com.google.gson.annotations.SerializedName
import com.rahmat.app.footballclub.entity.Event

/**
 * Created by muhrahmatullah on 15/09/18.
 */
data class SearchedMatches(
        @SerializedName("event") var events: List<Event>
)