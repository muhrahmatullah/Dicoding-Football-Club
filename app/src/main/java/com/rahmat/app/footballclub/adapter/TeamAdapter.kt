package com.rahmat.app.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Team
import com.rahmat.app.footballclub.feature.teamdetail.TeamDetailActivity
import kotlinx.android.synthetic.main.item_teams.view.*
import org.jetbrains.anko.startActivity

/**
 * Created by muhrahmatullah on 12/09/18.
 */
class TeamAdapter(val teamList: List<Team>, val context: Context?): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(context).inflate(R.layout.item_teams, parent, false))
    }

    override fun getItemCount() = teamList.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamList[position])
    }


    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(team: Team){
            itemView.tvTeam.text = team.strTeam
            Glide.with(itemView.context)
                    .load(team.strTeamBadge)
                    .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                    .into(itemView.imgTeam)

            itemView.setOnClickListener {
                itemView.context.startActivity<TeamDetailActivity>("team" to team)
            }
        }

    }
}