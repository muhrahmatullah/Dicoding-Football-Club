package com.rahmat.app.footballclub.feature.favmatch

import android.util.Log
import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by muhrahmatullah on 03/09/18.
 */
class FavoriteMatchPresenter(val mView: FavoriteMatchContract.View,
                             val matchRepositoryImpl: MatchRepositoryImpl,
                             val localRepositoryImpl: LocalRepositoryImpl) : FavoriteMatchContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData() {
        Log.v("Terpanggil", "iyya")
        mView.showLoading()
        val favList = localRepositoryImpl.getMatchFromDb()
        Log.v("Terpanggil", "db"+favList.size)
        var eventList: MutableList<Event> = mutableListOf()
        for (fav in favList){
            compositeDisposable.add(matchRepositoryImpl.getEventById(fav.idEvent)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe{
                        Log.v("Terpanggil", ""+it.events[0].strEvent)
                        Log.v("Terpanggil", ""+fav.idEvent)
                        eventList.add(it.events[0])
                        mView.displayFootballMatch(eventList)
                        mView.hideLoading()
                        mView.hideSwipeRefresh()
                    })
        }

        if(favList.isEmpty()){
            mView.hideLoading()
            mView.hideSwipeRefresh()
            mView.displayFootballMatch(eventList)
        }
    }
}