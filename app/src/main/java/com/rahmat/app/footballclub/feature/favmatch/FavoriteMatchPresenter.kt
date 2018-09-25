package com.rahmat.app.footballclub.feature.favmatch

import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

/**
 * Created by muhrahmatullah on 03/09/18.
 */
class FavoriteMatchPresenter(val mView: FavoriteMatchContract.View,
                             val matchRepositoryImpl: MatchRepositoryImpl,
                             val localRepositoryImpl: LocalRepositoryImpl,
                             val scheduler: SchedulerProvider) : FavoriteMatchContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData() {
        mView.showLoading()
        val favList = localRepositoryImpl.getMatchFromDb()
        var eventList: MutableList<Event> = mutableListOf()
        for (fav in favList){
            compositeDisposable.add(matchRepositoryImpl.getEventById(fav.idEvent)
                    .observeOn(scheduler.ui())
                    .subscribeOn(scheduler.io())
                    .subscribeWith(object: ResourceSubscriber<FootballMatch>(){
                        override fun onComplete() {
                            mView.hideLoading()
                            mView.hideSwipeRefresh()
                        }

                        override fun onNext(t: FootballMatch) {
                            eventList.add(t.events[0])
                            mView.displayFootballMatch(eventList)
                        }

                        override fun onError(t: Throwable?) {
                            mView.displayFootballMatch(Collections.emptyList())
                        }

                    })
            )
        }

        if(favList.isEmpty()){
            mView.hideLoading()
            mView.hideSwipeRefresh()
            mView.displayFootballMatch(eventList)
        }
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}