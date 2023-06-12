package com.example.cobafragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cobafragment2.data.MenuViewModel
import com.example.cobafragment2.databinding.FragmentPilihanMinumanBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMenuMinuman.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMenuMinuman : Fragment() {

    private lateinit var binding: FragmentPilihanMinumanBinding
    private var _binding : FragmentPilihanMinumanBinding? = null
    private val bindings get() = _binding!!
    private lateinit var mMenuViewModel: MenuViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPilihanMinumanBinding.inflate(layoutInflater,container,false)
        binding = FragmentPilihanMinumanBinding.inflate(layoutInflater,container,false)

        //Menyiapkan Adapter
        val adapter = MenuListAdapter(this)
        val rvListMenuMinuman = binding.rvMenuMinuman

        //Menambahkan adapter ke recycleView
        rvListMenuMinuman.adapter = adapter
        rvListMenuMinuman.layoutManager = LinearLayoutManager(requireContext())

        mMenuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        mMenuViewModel.readMenuMinumanData.observe(viewLifecycleOwner){
            menu -> adapter.setData(menu)
        }
        return binding.root
    }

}