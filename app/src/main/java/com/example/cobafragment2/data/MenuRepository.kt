package com.example.cobafragment2.data

import androidx.lifecycle.LiveData

class MenuRepository(private val menuDao: MenuDao) {
    val readAllData : LiveData<List<Menu>> = menuDao.readAllData()
    val readMenuMakananData : LiveData<List<Menu>> = menuDao.getMakananMenu()
    val readMenuMinumanData : LiveData<List<Menu>> = menuDao.getMinumanMenu()


}