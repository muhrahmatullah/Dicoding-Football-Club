package com.rahmat.app.footballclub.feature.lastmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter

import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.adapter.ClubAdapter
import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.extensions.hide
import com.rahmat.app.footballclub.extensions.show
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.fragment_last_match.*


class LastMatchFragment : Fragment(), MatchContract.View {

    lateinit var mPresenter : LastMatchPresenter
    lateinit var leagueName : String

    private var matchLists : MutableList<Event> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = FootballApiService.getClient().create(FootballRest::class.java)
        val request = MatchRepositoryImpl(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = LastMatchPresenter(this, request, scheduler)
        mPresenter.getFootballMatchData()
        val spinnerItems = resources.getStringArray(R.array.leagueArray)
        val spinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spinnerMatch.adapter = spinnerAdapter

        spinnerMatch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                leagueName = spinnerMatch.selectedItem.toString()
                when(leagueName){
                    "English Premier League" -> mPresenter.getFootballMatchData("4328")
                    "German Bundesliga" -> mPresenter.getFootballMatchData("4331")
                    "Italian Serie A" -> mPresenter.getFootballMatchData("4332")
                    "French Ligue 1" -> mPresenter.getFootballMatchData("4334")
                    "Spanish La Liga" -> mPresenter.getFootballMatchData("4335")
                    "Netherlands Eredivisie" -> mPresenter.getFootballMatchData("4337")
                    else -> mPresenter.getFootballMatchData()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_last_match, container, false)
    }

    override fun hideLoading() {
        mainProgressBar.hide()
        rvFootballLast.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBar.show()
        rvFootballLast.visibility = View.INVISIBLE
    }

    override fun displayFootballMatch(matchList: List<Event>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvFootballLast.layoutManager = layoutManager
        rvFootballLast.adapter = ClubAdapter(matchList, context)
    }
    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroyPresenter()
    }

}
