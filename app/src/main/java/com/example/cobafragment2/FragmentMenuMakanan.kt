package com.example.cobafragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cobafragment2.data.MenuViewModel
import com.example.cobafragment2.databinding.FragmentPilihanMakananBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMenuMakanan.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMenuMakanan : Fragment() {

    private lateinit var binding: FragmentPilihanMakananBinding
    private var _binding : FragmentPilihanMakananBinding? = null
    private val bindings get() = _binding!!
    private lateinit var mMenuViewModel : MenuViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPilihanMakananBinding.inflate(layoutInflater,container,false)
        binding = FragmentPilihanMakananBinding.inflate(layoutInflater,container,false)


        //Menyiapkan Adapter
        val adapter = MenuListAdapter(this)
        val rvListMenuMakanan = binding.rvMenuMakanan

        //Menambahkan adapter ke recycleView
        rvListMenuMakanan.adapter = adapter
        rvListMenuMakanan.layoutManager = LinearLayoutManager(requireContext())

        mMenuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        mMenuViewModel.readMenuMakananData.observe(viewLifecycleOwner)
        {
                menu -> adapter.setData(menu)
        }

        return binding.root
    }
}


