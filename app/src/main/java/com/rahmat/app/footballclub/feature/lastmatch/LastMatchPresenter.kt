package com.rahmat.app.footballclub.feature.lastmatch

import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by muhrahmatullah on 03/09/18.
 */
class LastMatchPresenter(val mView :  MatchContract.View,
                         val matchRepositoryImpl: MatchRepositoryImpl,
                         val scheduler: SchedulerProvider) : MatchContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData() {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getFootballMatch("4328")
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe{
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}