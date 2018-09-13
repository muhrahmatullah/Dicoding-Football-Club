package com.rahmat.app.footballclub.feature.teamdetail

import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl

/**
 * Created by muhrahmatullah on 12/09/18.
 */
class TeamDetailPresenter(val mView: TeamDetailContract.View,
                          val localRepositoryImpl: LocalRepositoryImpl): TeamDetailContract.Presenter {


    override fun deleteTeam(id: String) {
        localRepositoryImpl.deleteTeamData(id)
    }

    override fun checkTeam(id: String) {
        mView.setFavoriteState(localRepositoryImpl.checkFavTeam(id))
    }

    override fun insertTeam(id: String, imgUrl: String) {
        localRepositoryImpl.insertTeamData(id, imgUrl)
    }


}