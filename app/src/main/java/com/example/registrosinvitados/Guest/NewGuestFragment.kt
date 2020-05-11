package com.example.registrosinvitados.Guest

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.registrosinvitados.Objects.InjectorUtils
import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentListBinding
import com.example.registrosinvitados.databinding.FragmentNewGuestBinding
import kotlinx.android.synthetic.main.fragment_new_guest.*
import model.Model

/**
 * A simple [Fragment] subclass.
 */
class NewGuestFragment : Fragment() {

    private lateinit var binding: FragmentNewGuestBinding
    private var text:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNewGuestBinding>(
            inflater,
            R.layout.fragment_new_guest, container, false
        )
        binding.buttonList.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_newGuestFragment_to_listFragment)
    }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.yes, menu)
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
