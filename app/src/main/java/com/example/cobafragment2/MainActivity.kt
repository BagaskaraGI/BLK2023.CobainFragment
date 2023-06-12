package com.example.cobafragment2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.room.Room
import com.example.cobafragment2.data.Menu
import com.example.cobafragment2.data.MenuDatabase
import com.example.cobafragment2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context: Context = applicationContext
        val menuMakanan1 = Menu(1,"Nasi Goreng", 20000, R.drawable._f722f788063d,context.getString(R.string.desc_menu_makanan_3),"Makanan")
        val menuMakanan2 = Menu(2,"Sapo Tahu", 17000, R.drawable.sapo_tahu,context.getString(R.string.desc_menu_makanan_2),"Makanan")
        val menuMakanan3 = Menu(3,"Cumi Crispy Telur Asin", 23000, R.drawable.cumi_crispy_telur_asin,context.getString(R.string.desc_menu_makanan_1),"Makanan")

        val menuMinuman1 = Menu(4,"Es Teh Manis", 5000, R.drawable.es_teh_manis,context.getString(R.string.desc_menu_minuman_1),"Minuman")
        val menuMinuman2 = Menu(5,"Jus Jeruk", 7000, R.drawable.jus_jeruk,context.getString(R.string.desc_menu_makanan_2),"Minuman")
        val menuMinuman3 = Menu(6,"Jus Alpukat", 10000, R.drawable.manfaat_jus_alpukat,context.getString(R.string.desc_menu_makanan_3),"Minuman")



        val listMenu : List<Menu> = listOf(menuMakanan1, menuMakanan2, menuMakanan3, menuMinuman1, menuMinuman2,menuMinuman3)


        // Step 5: Insert data into the database
        val menuDao = MenuDatabase.getDatabase(context).menuDao()
//        menuDao.insertMenus(listMenu)
        lifecycleScope.launch(Dispatchers.IO) {
            menuDao.insertMenus(listMenu)
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(this,navController)

        setupWithNavController(binding.bottomNav, navController)
    }
}