package com.example.registrosinvitados.Role

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.registrosinvitados.Guest.GuestViewModel
import com.example.registrosinvitados.Objects.InjectorUtils

import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentRoleBinding

/**
 * A simple [Fragment] subclass.
 */
class RoleFragment : Fragment() {

    private lateinit var binding: FragmentRoleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentRoleBinding>(
            inflater,
            R.layout.fragment_role, container, false
        )
        initializeUi()
        binding.floatingActionButton.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_roleFragment_to_role2Fragment2)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun initializeUi() {
        val factory =
            InjectorUtils.provideGuestViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(GuestViewModel::class.java)
        viewModel.getRole().observe(this, Observer { role ->
            val stringBuilder = StringBuilder()
            role.sortedBy { it.order }
            role.forEach { role ->
                stringBuilder.append("Rol ${role.order}\nNombre: ${role.name}\nDescripcion: ${role.description}\nOrden: ${role.rol}\n\n")
            }
            binding.rolText.text=stringBuilder.toString()


        })


    }




}



