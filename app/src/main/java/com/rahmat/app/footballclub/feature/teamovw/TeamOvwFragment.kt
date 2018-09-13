package com.rahmat.app.footballclub.feature.teamovw


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Team
import kotlinx.android.synthetic.main.fragment_team_ovw.*

class TeamOvwFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_ovw, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val team: Team? = arguments?.getParcelable("teams")
        initView(team)
    }

    fun initView(teamInfo: Team?){
        Glide.with(this)
                .load(teamInfo?.strTeamBadge)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(imgBadge)

        teamName.text = teamInfo?.strTeam
        tvManager.text = teamInfo?.strManager
        tvStadium.text = teamInfo?.strStadium
        teamOverview.text = teamInfo?.strDescriptionEN
    }


}
