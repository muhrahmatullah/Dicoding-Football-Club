package com.rahmat.app.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.rahmat.app.footballclub.feature.detail.DetailActivity
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Event
import kotlinx.android.synthetic.main.main_match_item.view.*
import org.jetbrains.anko.*

/**
 * Created by muhrahmatullah on 29/08/18.
 */
class ClubAdapter(val eventList:List<Event>, val context:Context?): RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.main_match_item, parent, false))
    }

    override fun getItemCount(): Int = eventList.size


    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ClubViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event:Event){
            if(event.intHomeScore == null) {
                itemView.dateScheduleTv.setTextColor(itemView.context.getColor(R.color.upcoming_match))
            }
            itemView.dateScheduleTv.text = event.dateEvent
            itemView.homeNameTv.text = event.strHomeTeam
            itemView.homeScoreTv.text = event.intHomeScore
            itemView.awayNameTv.text = event.strAwayTeam
            itemView.awayScoreTv.text = event.intAwayScore

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("match" to event)
            }
        }
    }

}