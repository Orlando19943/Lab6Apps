package com.example.registrosinvitados.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.registrosinvitados.Guest.GuestViewModel
import com.example.registrosinvitados.Objects.InjectorUtils
import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentRegistryBinding
import com.example.registrosinvitados.databinding.FragmentResultsBinding
import model.Model

/**
 * A simple [Fragment] subclass.
 */
class RegistryFragment : Fragment() {

    private var n = 0
    private var Invitados:String = "Invitados: "
    private lateinit var binding:FragmentRegistryBinding
    private val guest = Model();
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentRegistryBinding>(inflater,
            R.layout.fragment_registry,container,false)
        initializeUi()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.yes_no, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.add -> {

            val factory =
                InjectorUtils.provideGuestViewModelFactory()
            val viewModel = ViewModelProviders.of(this, factory)
                .get(GuestViewModel::class.java)
            viewModel.getGuest().observe(this, Observer { guest ->
                val stringBuilder = StringBuilder()
                guest.forEach { guest ->
                    stringBuilder.append("$guest\n\n")
                }
                binding.nombreTxt.text = "Nombre: ${guest.get(n).name}"
                binding.telefonoTxt.text = "Telefono: ${guest.get(n).phone}"
                binding.emailTxt.text = "Correo: ${guest.get(n).email}"
                guest.get(n).registered = "Si"
                Invitados += "${guest.get(n).name}|${guest.get(n).registered}\n"
                if(n == guest.size-1){
                    Invitados += "Gracias por usar la aplicacion"
                    view?.findNavController()?.navigate(R.id.action_registryFragment_to_resultsFragment)
                    Toast.makeText(activity, Invitados, Toast.LENGTH_SHORT).show()
                }
                n+=1
                if (n <= guest.size-1){
                    binding.nombreTxt.text = "Nombre: ${guest.get(n).name}"
                    binding.telefonoTxt.text = "Telefono: ${guest.get(n).phone}"
                    binding.emailTxt.text = "Correo: ${guest.get(n).email}"
                }
            })
            true
        }
        R.id.notRegistered -> {
            val factory =
                InjectorUtils.provideGuestViewModelFactory()
            val viewModel = ViewModelProviders.of(this, factory)
                .get(GuestViewModel::class.java)
            viewModel.getGuest().observe(this, Observer { guest ->
                val stringBuilder = StringBuilder()
                guest.forEach { guest ->
                    stringBuilder.append("$guest\n\n")
                }
                binding.nombreTxt.text = "Nombre: ${guest.get(n).name}"
                binding.telefonoTxt.text = "Telefono: ${guest.get(n).phone}"
                binding.emailTxt.text = "Correo: ${guest.get(n).email}"
                guest.get(n).registered = "No"
                Invitados += "${guest.get(n).name}|${guest.get(n).registered}\n"
                if(n == guest.size-1){
                    Invitados += "Gracias por usar la aplicacion"
                    view?.findNavController()?.navigate(R.id.action_registryFragment_to_resultsFragment)
                    //Toast.makeText(activity, Invitados, Toast.LENGTH_SHORT).show()
                }
                n+=1
                if (n <= guest.size-1){
                    binding.nombreTxt.text = "Nombre: ${guest.get(n).name}"
                    binding.telefonoTxt.text = "Telefono: ${guest.get(n).phone}"
                    binding.emailTxt.text = "Correo: ${guest.get(n).email}"
                }
            })
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    private fun initializeUi() {
        val factory =
            InjectorUtils.provideGuestViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(GuestViewModel::class.java)
        viewModel.getGuest().observe(this, Observer { guest ->
            val stringBuilder = StringBuilder()
            guest.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.nombreTxt.text = "Nombre: ${guest.get(0).name}"
            binding.telefonoTxt.text = "Telefono: ${guest.get(0).phone}"
            binding.emailTxt.text = "Correo: ${guest.get(0).email}"
            binding.rolTxt.text = "Rol: ${guest.get(0).role_id}"
        })


    }





}
