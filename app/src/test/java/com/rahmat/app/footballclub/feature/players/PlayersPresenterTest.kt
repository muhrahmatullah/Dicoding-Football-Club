package com.rahmat.app.footballclub.feature.players

import com.rahmat.app.footballclub.entity.*
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.PlayersRepositoryImpl
import com.rahmat.app.footballclub.feature.lastmatch.LastMatchPresenter
import com.rahmat.app.footballclub.feature.lastmatch.MatchContract
import com.rahmat.app.footballclub.utils.SchedulerProvider
import com.rahmat.app.footballclub.utils.TestSchedulerProvider
import io.reactivex.Flowable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muhrahmatullah on 15/09/18.
 */
class PlayersPresenterTest {

    @Mock
    lateinit var mView: PlayersContract.View

    @Mock
    lateinit var playersRepositoryImpl: PlayersRepositoryImpl

    lateinit var scheduler: SchedulerProvider

    lateinit var mPresenter: PlayersPresenter

    lateinit var player : FootballPlayer

    lateinit var playersDetail: Flowable<FootballPlayer>

    private val playerList = mutableListOf<Player>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        scheduler = TestSchedulerProvider()
        player = FootballPlayer(playerList)
        playersDetail = Flowable.just(player)
        mPresenter = PlayersPresenter(mView, playersRepositoryImpl, scheduler)
        `when`(playersRepositoryImpl.getAllPlayers("123")).thenReturn(playersDetail)

    }

    @Test
    fun getAllPlayer() {
        mPresenter.getAllPlayer("123")
        verify(mView).showLoading()
        verify(mView).displayPlayers(playerList)
        verify(mView).hideLoading()
    }
}