package com.rahmat.app.footballclub.feature.teamdetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.adapter.ViewPagerAdapter
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.feature.players.PlayersFragment
import com.rahmat.app.footballclub.feature.teamovw.TeamOvwFragment
import kotlinx.android.synthetic.main.activity_team_detail.*


class TeamDetailActivity : AppCompatActivity(), TeamDetailContract.View {

    lateinit var team: Team

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        setSupportActionBar(toolbar)

        team = intent.getParcelableExtra("team")
        val bundle = Bundle()
        bundle.putParcelable("teams", team)
        loadImage()
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val teamFragment = TeamOvwFragment()
        val playersFragment = PlayersFragment()
        teamFragment.arguments = bundle
        playersFragment.arguments = bundle
        adapter.populateFragment(teamFragment, "Team Overview")
        adapter.populateFragment(playersFragment, "Players")
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)
    }

    private fun loadImage(){
        if (!team.strTeamFanart1.equals(null)){
        Glide.with(applicationContext)
                .load(team.strTeamFanart1)
                .apply(RequestOptions().placeholder(R.drawable.
                        ic_hourglass_empty_black_24dp))
                .apply(RequestOptions().override(220, 160))
                .into(imageTeam)
        }else{
            Glide.with(applicationContext)
                    .load(team.strTeamBadge)
                    .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                    .apply(RequestOptions().override(120, 140))
                    .into(imageTeam)
        }
    }
}
