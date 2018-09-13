package com.rahmat.app.footballclub.feature.players


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.adapter.PlayerAdapter
import com.rahmat.app.footballclub.adapter.TeamAdapter
import com.rahmat.app.footballclub.entity.Player
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.PlayersRepositoryImpl
import com.rahmat.app.footballclub.extensions.hide
import com.rahmat.app.footballclub.extensions.show
import com.rahmat.app.footballclub.feature.lastmatch.LastMatchPresenter
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.fragment_players.*
import kotlinx.android.synthetic.main.fragment_teams.*

class PlayersFragment : Fragment(), PlayersContract.View {

    private var listPlayer : MutableList<Player> = mutableListOf()
    lateinit var mPresenter: PlayersContract.Presenter

    override fun showLoading() {
        playerProgressbar.show()
        rvPlayer.visibility = View.GONE
    }

    override fun hideLoading() {
        playerProgressbar.hide()
        rvPlayer.visibility = View.VISIBLE
    }

    override fun displayPlayers(playerList: List<Player>) {
        listPlayer.clear()
        listPlayer.addAll(playerList)
        val layoutManager = GridLayoutManager(context, 3)
        rvPlayer.layoutManager = layoutManager
        rvPlayer.adapter = PlayerAdapter(listPlayer, context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val team: Team? = arguments?.getParcelable("teams")
        val service = FootballApiService.getClient().create(FootballRest::class.java)
        val request = PlayersRepositoryImpl(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = PlayersPresenter(this, request, scheduler)
        mPresenter.getAllPlayer(team?.idTeam)

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }


}
