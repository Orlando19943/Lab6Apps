package com.example.registrosinvitados

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.registrosinvitados.databinding.FragmentRegistryBinding
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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
    /*
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
    }*/
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.add -> {
            // User chose the "Settings" item, show the app settings UI...
            val factory = InjectorUtils.provideGuestViewModelFactory()
            val viewModel = ViewModelProviders.of(this, factory)
                .get(GuestViewModel::class.java)
            // Observing LiveData from the QuotesViewModel which in turn observes
            // LiveData from the repository, which observes LiveData from the DAO ☺
            viewModel.getGuest().observe(this, Observer { guest ->
                val stringBuilder = StringBuilder()
                guest.forEach { guest ->
                    stringBuilder.append("$guest\n\n")
                }
                binding.nombreTxt.text = "Nombre: ${guest.get(n).name}"
                binding.telefonoTxt.text = "Telefono: ${guest.get(n).phone}"
                binding.emailTxt.text = "Correo: ${guest.get(n).email}"
                guest.get(n).registered = "Si"
                if(n == guest.size-1){
                    view?.findNavController()?.navigate(R.id.action_registryFragment_to_resultsFragment)
                    Toast.makeText(activity, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(activity, "${guest.get(n).toString()}", Toast.LENGTH_SHORT).show()
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
            // User chose the "Settings" item, show the app settings UI...
            // User chose the "Settings" item, show the app settings UI...
            val factory = InjectorUtils.provideGuestViewModelFactory()
            val viewModel = ViewModelProviders.of(this, factory)
                .get(GuestViewModel::class.java)
            // Observing LiveData from the QuotesViewModel which in turn observes
            // LiveData from the repository, which observes LiveData from the DAO ☺
            viewModel.getGuest().observe(this, Observer { guest ->
                val stringBuilder = StringBuilder()
                guest.forEach { guest ->
                    stringBuilder.append("$guest\n\n")
                }
                binding.nombreTxt.text = "Nombre: ${guest.get(n).name}"
                binding.telefonoTxt.text = "Telefono: ${guest.get(n).phone}"
                binding.emailTxt.text = "Correo: ${guest.get(n).email}"
                guest.get(n).registered = "No"
                if(n == guest.size-1){
                    view?.findNavController()?.navigate(R.id.action_registryFragment_to_resultsFragment)
                    Toast.makeText(activity, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(activity, "${guest.get(n).toString()}", Toast.LENGTH_SHORT).show()
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
            binding.nombreTxt.text = "Nombre: ${guest.get(0).name}"
            binding.telefonoTxt.text = "Telefono: ${guest.get(0).phone}"
            binding.emailTxt.text = "Correo: ${guest.get(0).email}"
        })


    }





}
