package com.rahmat.app.footballclub.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.rahmat.app.footballclub.feature.main.DetailActivity
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Club
import org.jetbrains.anko.*

/**
 * Created by muhrahmatullah on 29/08/18.
 */
class ClubAdapter(var clubList:List<Club>) : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(
                ItemFootball().createView(
                        AnkoContext.create(parent.context, parent)
                )
        )
    }

    override fun getItemCount(): Int {
        return clubList.size
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(clubList[position])
    }


    class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgFc: ImageView = itemView.find(R.id.img_fc)
        val txtFc: TextView = itemView.find(R.id.txt_fc)

        fun bind(club: Club){
            Glide.with(itemView.context)
                    .load(club.image)
                    .into(imgFc)
            txtFc.text = club.name
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("club" to club)
            }
        }
    }


    class ItemFootball : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            relativeLayout {
                imageView{
                    id = R.id.img_fc
                }.lparams(width = 120, height = 120) {
                    padding = dip(8)
                }

                textView {
                    id = R.id.txt_fc
                    textSize = 18f
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    centerVertically()
                    rightOf(R.id.img_fc)
                    leftMargin = dip(8)
                }

                id = R.id.relative_layout_container
                lparams(width = matchParent, height = wrapContent) {
                    padding = dip(8)
                }
            }
        }
    }
}