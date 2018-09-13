package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.Teams
import io.reactivex.Flowable

/**
 * Created by muhrahmatullah on 10/09/18.
 */
interface TeamRepository {

    fun getTeams(id : String = "0") : Flowable<Teams>

    fun getTeamsDetail(id : String = "0") : Flowable<Teams>
}