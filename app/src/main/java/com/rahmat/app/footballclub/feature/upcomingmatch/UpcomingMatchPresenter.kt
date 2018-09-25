package com.rahmat.app.footballclub.feature.upcomingmatch

import android.util.Log
import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.feature.lastmatch.MatchContract
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

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

    override fun getFootballMatchData(leagueName: String) {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.getUpcomingMatch(leagueName)
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribeWith(object: ResourceSubscriber<FootballMatch>(){
                    override fun onComplete() {
                        mView.hideLoading()
                    }

                    override fun onNext(t: FootballMatch) {
                        mView.displayFootballMatch(t.events)
                    }

                    override fun onError(t: Throwable?) {
                        mView.hideLoading()
                        mView.displayFootballMatch(Collections.emptyList())
                    }

                })
                )
    }
}