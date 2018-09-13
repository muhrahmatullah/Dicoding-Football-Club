package com.rahmat.app.footballclub.feature.favteam

import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.TeamRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by muhrahmatullah on 14/09/18.
 */
class FavoriteTeamPresenter(val mView: FavoriteTeamContract.View,
                            val localRepositoryImpl: LocalRepositoryImpl,
                            val teamRepositoryImpl: TeamRepositoryImpl,
                            val scheduler: SchedulerProvider): FavoriteTeamContract.Presenter {


    val compositeDisposable = CompositeDisposable()

    override fun getTeamData() {
        mView.showLoading()
        val teamList = localRepositoryImpl.getTeamFromDb()
        var teamLists: MutableList<Team> = mutableListOf()
        for (fav in teamList){
            compositeDisposable.add(teamRepositoryImpl.getTeamsDetail(fav.idTeam)
                    .observeOn(scheduler.ui())
                    .subscribeOn(scheduler.io())
                    .subscribe{
                        teamLists.add(it.teams[0])
                        mView.displayTeams(teamLists)
                        mView.hideLoading()
                        mView.hideSwipeRefresh()
                    })
        }

        if(teamList.isEmpty()){
            mView.hideLoading()
            mView.hideSwipeRefresh()
            mView.displayTeams(teamLists)
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}