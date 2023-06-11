package com.example.cobafragment2.data

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cobafragment2.FragmentMenuMakanan
import com.example.cobafragment2.FragmentMenuMinuman

class MenuViewModel(application: Application):AndroidViewModel(application) {
    val readAllData : LiveData<List<Menu>>
    val readMenuMakananData : LiveData<List<Menu>>
    val readMenuMinumanData : LiveData<List<Menu>>
//    val readData : LiveData<List<Menu>>
    private val repository : MenuRepository

    init {
        val menuDao = MenuDatabase.getDatabase(application).menuDao()
        repository = MenuRepository(menuDao)

//        readData = when(fragment){
//            is FragmentMenuMakanan -> repository.readMenuMakananData
//            is FragmentMenuMinuman -> repository.readMenuMinumanData
//            else -> repository.readAllData
//        }
        readAllData = repository.readAllData
        readMenuMakananData = repository.readMenuMakananData
        readMenuMinumanData = repository.readMenuMinumanData
    }
}


//To Costumized the ViewModel
//class MenuViewModelFactory(private val application: Application, private val fragment: Fragment) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
//            return MenuViewModel(application, fragment) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}