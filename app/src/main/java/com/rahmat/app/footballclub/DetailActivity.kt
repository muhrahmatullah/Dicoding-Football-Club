package com.rahmat.app.footballclub

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.rahmat.app.footballclub.R.id.img_dtl
import com.rahmat.app.footballclub.entity.Club
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by muhrahmatullah on 29/08/18.
 */
class DetailActivity : AppCompatActivity() {

    lateinit var club: Club

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailUi().setContentView(this)
        val img = findViewById<ImageView>(R.id.img_dtl)
        val txt_club = findViewById<TextView>(R.id.txt_name_dtl)
        val txt_detail = findViewById<TextView>(R.id.txt_desc_dtl)
        club = intent.getParcelableExtra("club")
        txt_club.text = club.name
        txt_club.typeface = Typeface.DEFAULT_BOLD
        txt_detail.text = club.detail
        Glide.with(this)
                .load(club.image)
                .into(img)
    }

    class DetailUi : AnkoComponent<DetailActivity> {

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                imageView{
                    id = R.id.img_dtl
                }.lparams(400, 400){
                    bottomMargin = dip(20)
                    padding = dip(8)
                    gravity = Gravity.CENTER
                }
                textView{
                    id = R.id.txt_name_dtl
                    textSize = 18f
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(width = wrapContent, height = wrapContent){
                    bottomMargin = dip(20)
                    rightMargin = dip(10)
                    leftMargin = dip(10)
                    gravity = Gravity.CENTER
                }
                textView{
                    id = R.id.txt_desc_dtl
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(width = wrapContent, height = wrapContent){
                    rightMargin = dip(10)
                    leftMargin = dip(10)
                    gravity = Gravity.CENTER
                }.lparams(width = wrapContent, height = wrapContent){
                    gravity = Gravity.CENTER
                }
            }
        }

    }
}