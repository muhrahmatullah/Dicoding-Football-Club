package com.rahmat.app.footballclub.feature.players

import com.rahmat.app.footballclub.entity.repository.PlayersRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by muhrahmatullah on 13/09/18.
 */
class PlayersPresenter(val mView: PlayersContract.View,
                       val playersRepositoryImpl: PlayersRepositoryImpl,
                       val schedulerProvider: SchedulerProvider): PlayersContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getAllPlayer(teamId: String?) {
        mView.showLoading()
        compositeDisposable.add(playersRepositoryImpl.getAllPlayers(teamId)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe{
                    mView.hideLoading()
                    mView.displayPlayers(it.player)
                })
    }
    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}