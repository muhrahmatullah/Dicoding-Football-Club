package com.rahmat.app.footballclub.feature.lastmatch

import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.utils.SchedulerProvider
import com.rahmat.app.footballclub.utils.TestSchedulerProvider
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


/**
 * Created by muhrahmatullah on 05/09/18.
 */
class LastMatchPresenterTest {

    @Mock
    lateinit var mView: MatchContract.View

    @Mock
    lateinit var matchRepositoryImpl: MatchRepositoryImpl

    lateinit var scheduler: SchedulerProvider

    lateinit var mPresenter: LastMatchPresenter

    lateinit var match : FootballMatch

    lateinit var footballMatch: Flowable<FootballMatch>

    private val event = mutableListOf<Event>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        scheduler = TestSchedulerProvider()
        match = FootballMatch(event)
        footballMatch = Flowable.just(match)
        mPresenter = LastMatchPresenter(mView, matchRepositoryImpl, scheduler)
        `when`(matchRepositoryImpl.getFootballMatch("4328")).thenReturn(footballMatch)
    }

    @Test
    fun getFootballMatchData() {
        mPresenter.getFootballMatchData()
        verify(mView).showLoading()
        verify(mView).displayFootballMatch(event)
        verify(mView).hideLoading()
    }
}