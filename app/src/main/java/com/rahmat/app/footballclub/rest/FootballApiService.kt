package com.rahmat.app.footballclub.rest

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by muhrahmatullah on 01/09/18.
 */
class FootballApiService {

    companion object {
        fun getClient() : Retrofit{
            return Retrofit.Builder()
                    .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }
}