package com.rahmat.app.footballclub.feature.favteam


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.adapter.TeamAdapter
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.entity.repository.LocalRepositoryImpl
import com.rahmat.app.footballclub.entity.repository.TeamRepositoryImpl
import com.rahmat.app.footballclub.extensions.hide
import com.rahmat.app.footballclub.extensions.show
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.fragment_favorite_team.*

class FavoriteTeamFragment : Fragment(), FavoriteTeamContract.View {

    private var teamLists : MutableList<Team> = mutableListOf()
    lateinit var mPresenter : FavoriteTeamPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_team, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sercive = FootballApiService.getClient().create(FootballRest::class.java)
        val localRepositoryImpl = LocalRepositoryImpl(context!!)
        val teamRepositoryImpl = TeamRepositoryImpl(sercive)
        val scheduler = AppSchedulerProvider()
        mPresenter = FavoriteTeamPresenter(this, localRepositoryImpl, teamRepositoryImpl, scheduler)
        mPresenter.getTeamData()

        swiperefresh.setOnRefreshListener {
            mPresenter.getTeamData()
        }
    }


    override fun displayTeams(teamList: List<Team>) {
        teamLists.clear()
        teamLists.addAll(teamList)
        val layoutManager = GridLayoutManager(context, 3)
        rvTeam.layoutManager = layoutManager
        rvTeam.adapter = TeamAdapter(teamLists, context)
    }

    override fun hideLoading() {
        mainProgressBar.hide()
        rvTeam.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBar.show()
        rvTeam.visibility = View.GONE
    }

    override fun hideSwipeRefresh() {
        swiperefresh.isRefreshing = false
        mainProgressBar.hide()
        rvTeam.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }


}
