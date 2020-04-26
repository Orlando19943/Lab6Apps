package com.example.registrosinvitados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.registrosinvitados.databinding.FragmentRegistryBinding

/**
 * A simple [Fragment] subclass.
 */
class RegistryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistryBinding>(inflater,
            R.layout.fragment_title,container,false)
        return binding.root
    }

}
