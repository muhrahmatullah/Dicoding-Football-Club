package com.rahmat.app.footballclub.feature.team


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rahmat.app.footballclub.R

class TeamsFragment : Fragment(), TeamsContract.View {


    override fun displayTeams() {

    }

    override fun hideLoading() {

    }

    override fun showLoading() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }
}
