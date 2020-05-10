package com.example.registrosinvitados

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.registrosinvitados.databinding.FragmentRegistryBinding
import model.Model

/**
 * A simple [Fragment] subclass.
 */
class RegistryFragment : Fragment() {

    private var guest = Model(i = 1)
    private var n = 0
    private var Invitados:String = "Invitados: "
    private lateinit var binding:FragmentRegistryBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentRegistryBinding>(inflater,
            R.layout.fragment_registry,container,false)
        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.yes_no, menu)
    }
    @SuppressLint("SetTextI18n")
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.add -> {
            // User chose the "Settings" item, show the app settings UI...
            n += 1
            guest = Model(i = n,registered = "Si")
            binding.nombreTxt.text = "Nombre: ${guest.name}"
            binding.telefonoTxt.text = "Telefono: ${guest.phone}"
            binding.emailTxt.text = "Correo: ${guest.email}"
            Invitados += " ${guest.name},${guest.registered}"
            if(n == 8){
                view?.findNavController()?.navigate(R.id.action_registryFragment_to_resultsFragment)
                Toast.makeText(activity, Invitados, Toast.LENGTH_SHORT).show()
            }
            true
        }
        R.id.notRegistered -> {
            // User chose the "Settings" item, show the app settings UI...
            n += 1
            guest = Model(i = n,registered = "No")
            guest.registered = "No"
            binding.nombreTxt.text = "Nombre: ${guest.name}"
            binding. telefonoTxt.text = "Telefono: ${guest.phone}"
            binding.emailTxt.text = "Correo: ${guest.email}"
            Invitados += "${guest.name},${guest.registered}"
            if(n == 8){
                view?.findNavController()?.navigate(R.id.action_registryFragment_to_resultsFragment)
                Toast.makeText(activity, Invitados, Toast.LENGTH_SHORT).show()
            }
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }





}
