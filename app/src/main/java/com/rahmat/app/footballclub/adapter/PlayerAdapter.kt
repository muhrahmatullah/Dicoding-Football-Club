package com.rahmat.app.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Player
import com.rahmat.app.footballclub.feature.playerdetail.PlayerDetailActivity

import kotlinx.android.synthetic.main.item_players.view.*
import org.jetbrains.anko.startActivity


/**
 * Created by muhrahmatullah on 13/09/18.
 */
class PlayerAdapter(val listPlayer:List<Player>, val context:Context?):
        RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_players, parent, false))
    }

    override fun getItemCount()= listPlayer.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(listPlayer[position])
    }


    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(player: Player){
            itemView.tvPlayer.text = player.strPlayer
            Glide.with(itemView.context)
                    .load(player.strCutout)
                    .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                    .apply(RequestOptions().override(120, 140))
                    .into(itemView.imgPlayer)

            itemView.setOnClickListener {
                itemView.context.startActivity<PlayerDetailActivity>("player" to player)
            }
        }

    }
}