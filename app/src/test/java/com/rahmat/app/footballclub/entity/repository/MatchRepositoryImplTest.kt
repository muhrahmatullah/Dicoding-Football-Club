package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.rest.FootballRest
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muhrahmatullah on 05/09/18.
 */
class MatchRepositoryImplTest {

    @Mock
    lateinit var footballRest: FootballRest

    lateinit var matchRepositoryImpl: MatchRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        matchRepositoryImpl = MatchRepositoryImpl(footballRest)
    }

    @Test
    fun getEventById() {
        matchRepositoryImpl.getEventById("123")
        verify(footballRest).getEventById("123")
    }

    @Test
    fun getUpcomingMatch() {
        matchRepositoryImpl.getUpcomingMatch("123")
        verify(footballRest).getUpcomingMatch("123")
    }

    @Test
    fun getFootballMatch() {
        matchRepositoryImpl.getFootballMatch("123")
        verify(footballRest).getLastmatch("123")
    }

    @Test
    fun getTeams() {
        matchRepositoryImpl.getTeams("123")
        verify(footballRest).getTeam("123")
    }
}