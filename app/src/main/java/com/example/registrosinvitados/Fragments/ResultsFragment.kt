package com.example.registrosinvitados.Fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.registrosinvitados.Guest.GuestViewModel
import com.example.registrosinvitados.Objects.InjectorUtils
import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentResultsBinding

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment() {
    private var n = 0
    private var m = 0
    private lateinit var binding: FragmentResultsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentResultsBinding>(inflater,
            R.layout.fragment_results,container,false)
        initializeUi()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
    }

    private fun initializeUi() {
        val factory =
            InjectorUtils.provideGuestViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(GuestViewModel::class.java)
        viewModel.getGuest().observe(this, Observer { guest ->
            val stringBuilder = StringBuilder()
            guest.forEach { guest ->
                stringBuilder.append("$guest\n\n")
            }
            for (n in guest.indices) {
                if (guest[n].registered == "Si"){
                    m++
                }
            }
            binding.textGuest.text = "Invitados: ${guest.size}"
            binding.textRegistered.text = "Registrados: $m"
        })


    }





}
