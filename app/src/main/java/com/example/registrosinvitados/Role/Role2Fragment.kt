package com.example.registrosinvitados.Role

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.registrosinvitados.Guest.GuestViewModel
import com.example.registrosinvitados.Objects.InjectorUtils

import com.example.registrosinvitados.R
import com.example.registrosinvitados.databinding.FragmentRole2Binding
import model.Role

/**
 * A simple [Fragment] subclass.
 */
class Role2Fragment : Fragment() {

    private lateinit var binding: FragmentRole2Binding
    private var text:String = ""
    private var n: Int = 0
    private var m: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentRole2Binding>(
            inflater,
            R.layout.fragment_role2, container, false
        )
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                Toast.makeText(activity,"El valor del orden es: ${seekBar.progress}",Toast.LENGTH_SHORT).show()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })


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
            viewModel.getRole().observe(this, Observer { role ->
                val stringBuilder = StringBuilder()
                role.forEach { role ->
                    stringBuilder.append("$role\n\n")
                }
                n = role.size

            })
            if (TextUtils.isEmpty(binding.nameText.text.toString())||TextUtils.isEmpty(binding.descriptionText.text.toString())){
                Toast.makeText(activity, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }else {
                val role = Role(binding.nameText.text.toString(),binding.descriptionText.text.toString(),
                    binding.seekBar.progress,n+1)
                viewModel.addRole(role)
                Toast.makeText(activity, "Se añadio ${role.toString()}", Toast.LENGTH_SHORT).show()


            }


            true
        }

        else -> super.onOptionsItemSelected(item)
    }

}
