package com.example.registrosinvitados

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.registrosinvitados.databinding.FragmentNewGuestBinding
import kotlinx.android.synthetic.main.fragment_new_guest.*
import model.Model

/**
 * A simple [Fragment] subclass.
 */
class NewGuestFragment : Fragment() {

    private lateinit var binding: FragmentNewGuestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNewGuestBinding>(
            inflater,
            R.layout.fragment_new_guest, container, false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.yes, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.add -> {
            // User chose the "Settings" item, show the app settings UI...
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
                guest.forEach { guest ->
                    stringBuilder.append("$guest\n\n")
                }
            })
            val guest = Model(nameText.text.toString(),phoneText.text.toString(),
                emailText.text.toString())
            viewModel.addGuest(guest)
            Toast.makeText(activity, "Se añadio ${guest.toString()}", Toast.LENGTH_SHORT).show()

            true
        }

        else -> super.onOptionsItemSelected(item)
    }

}
