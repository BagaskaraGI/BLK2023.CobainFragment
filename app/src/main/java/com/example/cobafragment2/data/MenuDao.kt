package com.example.cobafragment2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MenuDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOneMenu(menu: Menu)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMenus(menus: List<Menu>)


    @Query("SELECT * FROM menu_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Menu>>

    @Query("SELECT * FROM menu_table WHERE tipeMenu = 'Makanan'")
    fun getMakananMenu(): LiveData<List<Menu>>

    @Query("SELECT * FROM menu_table WHERE tipeMenu = 'Minuman'")
    fun getMinumanMenu(): LiveData<List<Menu>>


}