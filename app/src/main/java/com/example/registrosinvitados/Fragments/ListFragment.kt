package com.example.registrosinvitados.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.registrosinvitados.Guest.GuestViewModel
import com.example.registrosinvitados.Objects.InjectorUtils

import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private var texto =""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentListBinding>(inflater,
            R.layout.fragment_list,container,false)
        initializeUi()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initializeUi() {
        val factory =
            InjectorUtils.provideGuestViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(GuestViewModel::class.java)
        viewModel.getGuest().observe(this, Observer { guest ->
            val stringBuilder = StringBuilder()
            var n = 1
            guest.forEach { guest ->
                stringBuilder.append("Invitado: $n\nNombre: ${guest.name}\nTelefono: ${guest.phone}\n" +
                        "Correo: ${guest.email}\nRol: ${guest.role_id}\n\n")
                n++
            }
            binding.textList.text=stringBuilder.toString()

        })


    }

}
