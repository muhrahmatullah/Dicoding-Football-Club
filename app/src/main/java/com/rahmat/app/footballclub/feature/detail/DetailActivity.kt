package com.rahmat.app.footballclub.feature.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.db.FavoriteMatch
import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

/**
 * Created by muhrahmatullah on 29/08/18.
 */
class DetailActivity : AppCompatActivity(), DetailContract.View {

    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null

    lateinit var event: Event

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
        val localRepo = LocalRepositoryImpl(applicationContext)
        mPresenter = DetailPresenter(this, request, localRepo)

        event = intent.getParcelableExtra("match")
        mPresenter.getTeamsBadgeAway(event.idAwayTeam)
        mPresenter.getTeamsBadgeHome(event.idHomeTeam)
        mPresenter.checkMatch(event.idEvent)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        menuItem = menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.favorite -> {
                if (!isFavorite){
                    mPresenter.insertMatch(
                            event.idEvent, event.idHomeTeam, event.idAwayTeam)
                    toast("Event added to favorite")
                    isFavorite = !isFavorite
                }else{
                    mPresenter.deleteMatch(event.idEvent)
                    toast("Event removed favorite")
                    isFavorite = !isFavorite
                }
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_fav_24dp)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_fav_24dp)
    }

    override fun setFavoriteState(favList: List<FavoriteMatch>) {
        if(!favList.isEmpty()) isFavorite = true
    }
}