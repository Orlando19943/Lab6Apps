package com.example.registrosinvitados.Guest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import model.GuestRepository

class GuestViewModelFactory(private val guestRepository: GuestRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GuestViewModel(
            guestRepository
        ) as T
    }
}