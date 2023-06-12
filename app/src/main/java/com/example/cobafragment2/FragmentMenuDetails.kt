package com.example.cobafragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cobafragment2.databinding.FragmentMenuDetailsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMenuDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMenuDetails : Fragment() {

    private  val args by navArgs<FragmentMenuDetailsArgs>()

    private var _binding: FragmentMenuDetailsBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuDetailsBinding.inflate(inflater,container,false)

        val view = binding.root

        binding.tvNamaMenu.text = args.currentMenu.namaMenu
        binding.tvHargaMenu.text = args.currentMenu.hargaMenu.toString()
        binding.tvDeskripsiMenu.text = args.currentMenu.deskripsiMenu
        binding.tvImageMenu.setImageResource(args.currentMenu.gambarMenuResID)

        binding.buttonAddToCart.setOnClickListener {
            when (args.currentMenu.tipeMenu){
             "Makanan" ->  this.findNavController().navigate(R.id.action_fragmentMenuDetails_to_MenuMakanan)
             "Minuman" ->   this.findNavController().navigate(R.id.action_fragmentMenuDetails_to_MenuMinuman)
            }
        }
        return view

    }

}