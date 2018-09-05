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
}