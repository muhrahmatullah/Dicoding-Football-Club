package com.rahmat.app.footballclub.feature.main

import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.Teams
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by muhrahmatullah on 01/09/18.
 */
class MainPresenter(val mView : MainContract.View, val matchRepositoryImpl: MatchRepositoryImpl) : MainContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballUpcomingData() {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getUpcomingMatch("4328")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })
    }

    override fun getFootballMatchData() {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getFootballMatch("4328")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })
    }
}