package com.rahmat.app.footballclub.entity.repository

import com.rahmat.app.footballclub.rest.FootballRest
import org.junit.Test

import org.junit.Before
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muhrahmatullah on 15/09/18.
 */
class TeamRepositoryImplTest {


    @Mock
    lateinit var footballRest: FootballRest

    lateinit var teamRepositoryImpl: TeamRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        teamRepositoryImpl = TeamRepositoryImpl(footballRest)
    }

    @Test
    fun getTeamBySearch() {
        teamRepositoryImpl.getTeamBySearch("query")
        verify(footballRest).getTeamBySearch("query")
    }

    @Test
    fun getTeams() {
        teamRepositoryImpl.getTeams("123")
        verify(footballRest).getAllTeam("123")
    }

    @Test
    fun getTeamsDetail() {
        teamRepositoryImpl.getTeamsDetail("id")
        verify(footballRest).getTeam("id")
    }

    @Test
    fun getAllTeam(){
        teamRepositoryImpl.getAllTeam("id")
        verify(footballRest).getAllTeam("id")
    }
}