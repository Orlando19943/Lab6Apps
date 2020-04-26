package com.example.registrosinvitados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.registrosinvitados.databinding.FragmentResultsBinding

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentResultsBinding>(inflater,
            R.layout.fragment_results,container,false)
        return binding.root
    }

}
