package com.rahmat.app.footballclub.feature.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.feature.FavoriteFragment
import com.rahmat.app.footballclub.feature.MatchesFragment
import com.rahmat.app.footballclub.feature.team.TeamsFragment
import com.rahmat.app.footballclub.feature.favmatch.FavoriteMatchFragment
import kotlinx.android.synthetic.main.bottom_nav_view.*
import kotlinx.android.synthetic.main.home_activity.*

class MainActivity : AppCompatActivity(), MainContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        setSupportActionBar(toolbar_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                 R.id.lastMatch -> {
                    loadMatch(savedInstanceState)
                }
                R.id.upMatch -> {
                    loadUpcomingMatch(savedInstanceState)
                }
                R.id.favMatch -> {
                    loadFavoritesMatch(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.lastMatch
    }

    private fun loadMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, MatchesFragment(), MatchesFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadUpcomingMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                    .commit()
        }
    }
}
