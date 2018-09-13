package com.rahmat.app.footballclub.feature.playerdetail

import com.rahmat.app.footballclub.entity.repository.PlayersRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by muhrahmatullah on 14/09/18.
 */
class PlayerDetailPresenter(val mView: PayerDetailContract.View,
                            val playersRepositoryImpl: PlayersRepositoryImpl,
                            val schedulerProvider: SchedulerProvider): PayerDetailContract.Presenter {


    val compositeDisposable = CompositeDisposable()

    override fun getPlayerData(idPlayer: String) {
        compositeDisposable.add(playersRepositoryImpl.getPlayerDetail(idPlayer)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe {
                    mView.displayPlayerDetail(it.player[0])
                })
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}