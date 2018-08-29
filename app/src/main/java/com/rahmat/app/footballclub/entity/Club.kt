package com.rahmat.app.footballclub.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by muhrahmatullah on 29/08/18.
 */
@Parcelize
data class Club(var name : String, var image : Int, var detail : String) : Parcelable