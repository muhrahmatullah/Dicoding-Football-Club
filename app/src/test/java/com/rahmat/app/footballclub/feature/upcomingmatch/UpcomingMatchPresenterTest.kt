package com.rahmat.app.footballclub.feature.upcomingmatch

import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.FootballMatch
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.feature.lastmatch.MatchContract
import com.rahmat.app.footballclub.utils.SchedulerProvider
import com.rahmat.app.footballclub.utils.TestSchedulerProvider
import io.reactivex.Flowable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by muhrahmatullah on 05/09/18.
 */
class UpcomingMatchPresenterTest {

    @Mock
    lateinit var mView: MatchContract.View

    @Mock
    lateinit var matchRepositoryImpl: MatchRepositoryImpl

    lateinit var scheduler: SchedulerProvider

    lateinit var mPresenter: UpcomingMatchPresenter

    lateinit var match : FootballMatch

    lateinit var footballMatch: Flowable<FootballMatch>

    private val event = mutableListOf<Event>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        scheduler = TestSchedulerProvider()
        match = FootballMatch(event)
        footballMatch = Flowable.just(match)
        mPresenter = UpcomingMatchPresenter(mView, matchRepositoryImpl, scheduler)
        Mockito.`when`(matchRepositoryImpl.getUpcomingMatch("4328")).thenReturn(footballMatch)
    }

    @Test
    fun getFootballMatchData() {
        mPresenter.getFootballMatchData()
        Mockito.verify(mView).showLoading()
        Mockito.verify(mView).displayFootballMatch(event)
        Mockito.verify(mView).hideLoading()
    }
}