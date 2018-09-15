package com.rahmat.app.footballclub.feature.searchmatches

import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

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
                .subscribe {
                    mView.hideLoading()
                    mView.displayMatch(it.events)
                })
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }


}