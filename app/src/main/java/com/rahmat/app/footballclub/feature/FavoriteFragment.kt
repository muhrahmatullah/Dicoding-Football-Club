package com.rahmat.app.footballclub.feature


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.adapter.ViewPagerAdapter
import com.rahmat.app.footballclub.feature.favmatch.FavoriteMatchFragment
import com.rahmat.app.footballclub.feature.favteam.FavoriteTeamFragment

class FavoriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vPager = view.findViewById<ViewPager>(R.id.viewpager)
        val tabs = view.findViewById<TabLayout>(R.id.tabs)
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.populateFragment(FavoriteMatchFragment(), "Favorite Match")
        adapter.populateFragment(FavoriteTeamFragment(), "Favorite Team")
        vPager.adapter = adapter
        tabs.setupWithViewPager(vPager)
    }


}
