package com.rahmat.app.footballclub.feature.detail

import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.feature.main.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by muhrahmatullah on 01/09/18.
 */
class DetailPresenter(val mView : DetailContract.View, val matchRepositoryImpl: MatchRepositoryImpl) : DetailContract.Presenter {

    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchRepositoryImpl.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayTeamBadgeHome(it.teams[0])
                })
    }

    val compositeDisposable = CompositeDisposable()

    override fun getTeamsBadgeAway(id:String) {
        compositeDisposable.add(matchRepositoryImpl.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayTeamBadgeAway(it.teams[0])
                })
    }
}