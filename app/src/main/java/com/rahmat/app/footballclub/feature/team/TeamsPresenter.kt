package com.rahmat.app.footballclub.feature.team

import com.rahmat.app.footballclub.entity.repository.TeamRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by muhrahmatullah on 10/09/18.
 */
class TeamsPresenter(val mView : TeamsContract.View, val teamRepositoryImpl: TeamRepositoryImpl,
                     val scheduler: SchedulerProvider): TeamsContract.Presenter {


    override fun searchTeam(teamName: String) {
        mView.showLoading()
        compositeDisposable.add(teamRepositoryImpl.footballRest.getTeamBySearch(teamName)
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe{
                    mView.displayTeams(it.teams)
                    mView.hideLoading()
                })
    }

    val compositeDisposable = CompositeDisposable()
    override fun getTeamData(leagueName: String) {
        mView.showLoading()
        compositeDisposable.add(teamRepositoryImpl.footballRest.getAllTeam(leagueName)
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe{
                    mView.displayTeams(it.teams)
                    mView.hideLoading()
                })
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

}