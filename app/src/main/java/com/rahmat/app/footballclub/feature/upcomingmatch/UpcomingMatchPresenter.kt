package com.rahmat.app.footballclub.feature.upcomingmatch

import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.feature.lastmatch.MatchContract
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by muhrahmatullah on 03/09/18.
 */
class UpcomingMatchPresenter(val mView: MatchContract.View,
                             val matchRepositoryImpl: MatchRepositoryImpl,
                             val scheduler: SchedulerProvider) : MatchContract.Presenter {


    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }

    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData() {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getUpcomingMatch("4328")
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe{
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })
    }
}