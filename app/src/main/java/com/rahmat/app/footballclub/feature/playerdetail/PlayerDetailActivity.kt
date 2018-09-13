package com.rahmat.app.footballclub.feature.playerdetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rahmat.app.footballclub.R
import com.rahmat.app.footballclub.entity.Player
import com.rahmat.app.footballclub.entity.repository.PlayersRepositoryImpl
import com.rahmat.app.footballclub.rest.FootballApiService
import com.rahmat.app.footballclub.rest.FootballRest
import com.rahmat.app.footballclub.utils.AppSchedulerProvider
import kotlinx.android.synthetic.main.activity_player_detail.*
import kotlinx.android.synthetic.main.player_layout_detail.*

class PlayerDetailActivity : AppCompatActivity(), PayerDetailContract.View {

    lateinit var player: Player
    lateinit var mPresenter: PayerDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)
        setSupportActionBar(toolbar)
        player = intent.getParcelableExtra("player")
        supportActionBar?.title = player.strPlayer
        val service = FootballApiService.getClient().create(FootballRest::class.java)
        val request = PlayersRepositoryImpl(service)
        val scheduler = AppSchedulerProvider()
        mPresenter = PlayerDetailPresenter(this, request, scheduler)
        mPresenter.getPlayerData(player.idPlayer)
    }

    override fun displayPlayerDetail(player: Player) {
        initView(player)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    private fun initView(player: Player){

        loadBanner(player)
        Glide.with(applicationContext)
                .load(player.strCutout)
                .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                .into(imgPlayer)


        playerName.text = player.strPlayer
        tvPosition.text = player.strPosition
        tvDate.text = player.dateBorn
        playerOverview.text = player.strDescriptionEN
    }

    private fun loadBanner(player: Player){
        if(!player.strFanart1.equals(null)){
            Glide.with(applicationContext)
                    .load(player.strFanart1)
                    .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                    .into(imageBannerPlayer)
        }else{
            Glide.with(applicationContext)
                    .load(player.strThumb)
                    .apply(RequestOptions().placeholder(R.drawable.ic_hourglass_empty_black_24dp))
                    .into(imageBannerPlayer)
        }
    }
}
