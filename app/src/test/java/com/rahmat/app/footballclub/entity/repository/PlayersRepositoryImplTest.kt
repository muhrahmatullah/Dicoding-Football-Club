package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.rest.FootballRest
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muhrahmatullah on 15/09/18.
 */
class PlayersRepositoryImplTest {

    @Mock
    lateinit var footballRest: FootballRest

    lateinit var playersRepositoryImpl: PlayersRepositoryImpl


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        playersRepositoryImpl = PlayersRepositoryImpl(footballRest)
    }

    @Test
    fun getAllPlayers() {
        playersRepositoryImpl.getAllPlayers("123")
        verify(footballRest).getAllPlayers("123")
    }

    @Test
    fun getPlayerDetail() {
        playersRepositoryImpl.getPlayerDetail("123")
        verify(footballRest).getPlayerDetail("123")
    }
}