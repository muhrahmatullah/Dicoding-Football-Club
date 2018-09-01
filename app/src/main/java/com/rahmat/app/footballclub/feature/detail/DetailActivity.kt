package com.rahmat.app.footballclub.feature.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by muhrahmatullah on 29/08/18.
 */
class DetailActivity : AppCompatActivity(), DetailContract.View {

    override fun displayTeamBadgeAway(team: Team) {
        Glide.with(applicationContext)
                .load(team.strTeamBadge)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(awayImg)
    }

    override fun displayTeamBadgeHome(team: Team) {
        Glide.with(applicationContext)
                .load(team.strTeamBadge)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(homeImg)
    }

    lateinit var mPresenter : DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val service = FootballApiService.getClient().create(FootballRest::class.java)
        val request = MatchRepositoryImpl(service)
        mPresenter = DetailPresenter(this, request)

        val event = intent.getParcelableExtra<Event>("match")
        mPresenter.getTeamsBadgeAway(event.idAwayTeam)
        mPresenter.getTeamsBadgeHome(event.idHomeTeam)
        initData(event)
        supportActionBar?.title = event.strEvent
    }

    fun initData(event:Event){
        if(event.intHomeScore == null) {
            dateScheduleTv.setTextColor(applicationContext.getColor(R.color.upcoming_match))
        }

        dateScheduleTv.text = event.dateEvent
        homeNameTv.text = event.strHomeTeam
        homeScoreTv.text = event.intHomeScore
        awayNameTv.text = event.strAwayTeam
        awayScoreTv.text = event.intAwayScore

        homeScorerTv.text = event.strHomeGoalDetails
        awayScorerTv.text= event.strAwayGoalDetails

        gkHomeTv.text = event.strHomeLineupGoalkeeper
        gkAwayTv.text = event.strAwayLineupGoalkeeper

        defHomeTv.text = event.strHomeLineupDefense
        defAwayTv.text = event.strAwayLineupDefense

        midHomeTv.text = event.strHomeLineupMidfield
        midAwayTv.text = event.strAwayLineupMidfield

        forHomeTv.text = event.strHomeLineupForward
        forAwayTv.text = event.strAwayLineupForward

        subHomeTv.text = event.strHomeLineupSubstitutes
        subAwayTv.text = event.strAwayLineupSubstitutes

    }



}