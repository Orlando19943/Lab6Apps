package com.example.registrosinvitados

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.registrosinvitados.databinding.FragmentTitleBinding
import model.Model


/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    private val guest = Model();
    private var n = 0;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)
        initializeUi()
        binding.Registry.setOnClickListener{view:View ->
            if (n>0){
                view.findNavController().navigate(R.id.action_titleFragment_to_registryFragment)
            }else {
                Toast.makeText(activity, "No hay invitados. Ingrese por lo menos a una persona para continuar", Toast.LENGTH_SHORT).show()
            }


        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun initializeUi() {
        // Get the QuotesViewModelFactory with all of it's dependencies constructed
        val factory = InjectorUtils.provideGuestViewModelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory)
            .get(GuestViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getGuest().observe(this, Observer { guest ->
            val stringBuilder = StringBuilder()
            guest.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
           n = guest.size
        })


    }

}


