package com.rahmat.app.footballclub.feature.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.adapter.ClubAdapter
import com.rahmat.app.footballclub.entity.Event
import com.rahmat.app.footballclub.entity.repository.MatchRepositoryImpl
import com.rahmat.app.footballclub.extensions.hide
import com.rahmat.app.footballclub.extensions.show
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger, MainContract.View {

    lateinit var mPresenter : MainPresenter

    private var matchLists : MutableList<Event> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = FootballApiService.getClient().create(FootballRest::class.java)
        val request = MatchRepositoryImpl(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getFootballMatchData()
    }

    override fun hideLoading() {
        mainProgressBar.hide()
        rvFootball.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBar.show()
        rvFootball.visibility = View.INVISIBLE
    }

    override fun displayFootballMatch(matchList: List<Event>) {
        Log.v("test", ""+matchList.size)
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = ClubAdapter(matchList, applicationContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.upcomingMatch -> mPresenter.getFootballUpcomingData()
            R.id.lastMach -> mPresenter.getFootballMatchData()
        }
        return true
    }
}
