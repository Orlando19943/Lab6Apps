package com.example.registrosinvitados.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentRoleBinding

/**
 * A simple [Fragment] subclass.
 */
class RoleFragment : Fragment() {

    private lateinit var binding: FragmentRoleBinding
    private var text:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRoleBinding>(
            inflater,
            R.layout.fragment_role, container, false
        )
        binding.buttonList.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_roleFragment_to_role2Fragment2)
        }
        setHasOptionsMenu(true)
        return binding.root
    }




}



