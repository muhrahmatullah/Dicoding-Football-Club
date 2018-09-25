package com.rahmat.app.footballclub.feature.searchmatches

import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.SearchedMatches
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

/**
 * Created by muhrahmatullah on 15/09/18.
 */
class SearchMatchPresenter(val mView: SearchMatchContract.View,
                           val matchRepositoryImpl: MatchRepositoryImpl,
                           val schedulerProvider: SchedulerProvider): SearchMatchContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun searchMatch(query: String?) {
        mView.showLoading()
        compositeDisposable.add(matchRepositoryImpl.searchMatches(query)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(object: ResourceSubscriber<SearchedMatches>(){
                    override fun onComplete() {
                        mView.hideLoading()
                    }

                    override fun onNext(t: SearchedMatches) {
                        mView.displayMatch(t.events ?: Collections.emptyList())
                    }

                    override fun onError(t: Throwable?) {
                        mView.displayMatch(Collections.emptyList())
                        mView.hideLoading()
                    }

                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }


}