package com.example.registrosinvitados.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentRole2Binding

/**
 * A simple [Fragment] subclass.
 */
class Role2Fragment : Fragment() {

    private lateinit var binding: FragmentRole2Binding
    private var text:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRole2Binding>(
            inflater,
            R.layout.fragment_role2, container, false
        )


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.yes, menu)
    }

}
