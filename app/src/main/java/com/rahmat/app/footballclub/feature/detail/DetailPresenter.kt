package com.rahmat.app.footballclub.feature.detail

import android.util.Log
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.Teams
import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.TeamRepositoryImpl
import com.rahmat.app.footballclub.feature.main.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

/**
 * Created by muhrahmatullah on 01/09/18.
 */
class DetailPresenter(val mView : DetailContract.View, val teamRepositoryImpl: TeamRepositoryImpl,
                      val localRepositoryImpl: LocalRepositoryImpl) : DetailContract.Presenter {
    override fun deleteMatch(id: String) {
        localRepositoryImpl.deleteData(id)
    }

    override fun checkMatch(id: String) {
        mView.setFavoriteState(localRepositoryImpl.checkFavorite(id))
    }

    override fun insertMatch(eventId: String, homeId: String, awayId: String) {
        localRepositoryImpl.insertData(eventId, homeId, awayId)
    }

    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(teamRepositoryImpl.getTeamsDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object: ResourceSubscriber<Teams>(){
                    override fun onComplete() {

                    }

                    override fun onNext(t: Teams) {
                        mView.displayTeamBadgeHome(t.teams[0])
                    }

                    override fun onError(t: Throwable?) {

                    }
                })
        )
    }

    val compositeDisposable = CompositeDisposable()

    override fun getTeamsBadgeAway(id:String) {
        compositeDisposable.add(teamRepositoryImpl.getTeamsDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object: ResourceSubscriber<Teams>(){
                    override fun onComplete() {

                    }

                    override fun onNext(t: Teams) {
                        mView.displayTeamBadgeHome(t.teams[0])
                    }

                    override fun onError(t: Throwable?) {

                    }
                })
                )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}