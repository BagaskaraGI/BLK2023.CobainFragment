package com.example.cobafragment2.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "menu_table")
data class Menu(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val namaMenu: String,
    val hargaMenu: Int,
    val gambarMenuResID: Int,
    val deskripsiMenu: String,
    val tipeMenu : String
) : Parcelable
