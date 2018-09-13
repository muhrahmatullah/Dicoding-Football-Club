package com.rahmat.app.footballclub.feature.teamdetail

import com.rahmat.app.footballclub.entity.db.FavoriteTeam

/**
 * Created by muhrahmatullah on 12/09/18.
 */
interface TeamDetailContract {

    interface View{
        fun setFavoriteState(favList:List<FavoriteTeam>)
    }

    interface Presenter{
        fun deleteTeam(id:String)
        fun checkTeam(id:String)
        fun insertTeam(id: String, imgUrl: String)
    }
}