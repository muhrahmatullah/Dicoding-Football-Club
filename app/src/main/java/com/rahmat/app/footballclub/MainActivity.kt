package com.rahmat.app.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.rahmat.app.footballclub.adapter.ClubAdapter
import com.rahmat.app.footballclub.entity.Club
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), AnkoLogger {

    var clubList : ArrayList<Club> = ArrayList()

    private val rvFootball by lazy {
        find<RecyclerView>(R.id.rv_football)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        initData()
        rvFootball.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, 0)
        rvFootball.addItemDecoration(dividerItemDecoration)
        val adapter = ClubAdapter(clubList)
        rvFootball.adapter = adapter
    }
    fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_description)
        val image = resources.obtainTypedArray(R.array.club_image)

        for(i in name.indices){
            clubList.add(Club(name[i], image.getResourceId(i,0), desc[i]))
        }
    }

    class MainActivityUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            relativeLayout {
                recyclerView{
                    id = R.id.rv_football
                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }
}
