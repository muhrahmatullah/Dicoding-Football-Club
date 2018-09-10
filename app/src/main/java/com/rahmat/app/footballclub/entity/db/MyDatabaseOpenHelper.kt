package com.rahmat.app.footballclub.entity.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by muhrahmatullah on 03/09/18.
 */
class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Favorite.db", null, 1) {

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(p0: SQLiteDatabase) {
        // Here you create tables
        p0.createTable(FavoriteMatch.TABLE_FAVORITE, true,
                FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteMatch.EVENT_ID to TEXT + UNIQUE,
                FavoriteMatch.HOME_TEAM_ID to TEXT,
                FavoriteMatch.AWAY_TEAM_ID to TEXT)
        p0.createTable(FavoriteTeam.TEAM_TABLE, true,
                FavoriteTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteTeam.TEAM_ID to TEXT,
                FavoriteTeam.TEAM_IMAGE to TEXT)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        p0.dropTable(FavoriteMatch.TABLE_FAVORITE, true)
        p0.dropTable(FavoriteTeam.TEAM_TABLE, true)
    }
}
// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)