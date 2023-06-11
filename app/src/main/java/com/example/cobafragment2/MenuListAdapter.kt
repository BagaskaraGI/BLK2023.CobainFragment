package com.example.cobafragment2

import android.util.Log
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cobafragment2.data.Menu

class MenuListAdapter(private val fragment: Fragment):RecyclerView.Adapter<MenuListAdapter.MyViewHolder>() {
    private var menuList = emptyList<Menu>()


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_layout_list_menu,parent,false))
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMenu = menuList[position]
        holder.itemView.findViewById<TextView>(R.id.judulMakanan).text = currentMenu.namaMenu
        holder.itemView.findViewById<TextView>(R.id.hargaMakanan).text = currentMenu.hargaMenu.toString()
        holder.itemView.findViewById<ImageView>(R.id.gambarMakanan).setImageResource(currentMenu.gambarMenuResID)

        holder.itemView.findViewById<CardView>(R.id.cardViewMakanan).setOnClickListener {
            val action = when(fragment){
                is FragmentMenuMakanan -> FragmentMenuMakananDirections.actionMenuMakananToFragmentMenuDetails(currentMenu)
                is FragmentMenuMinuman -> FragmentMenuMinumanDirections.actionMenuMinumanToFragmentMenuDetails(currentMenu)
                else -> throw IllegalStateException("Invalid fragment")
            }
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(daftarMenu : List<Menu> ){
        this.menuList = daftarMenu
        Log.d("MenuList", daftarMenu.toString())
        notifyDataSetChanged()
    }
}