package com.example.registrosinvitados

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.registrosinvitados.databinding.FragmentNewGuestBinding

/**
 * A simple [Fragment] subclass.
 */
class NewGuestFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNewGuestBinding>(inflater,
            R.layout.fragment_new_guest,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.yes, menu)
    }

}
