package com.example.registrosinvitados.Guest

import androidx.lifecycle.ViewModel
import model.GuestRepository
import model.Model

class GuestViewModel(private val guestRepository: GuestRepository)
    : ViewModel() {

    fun getGuest() = guestRepository.getQuotes()

    fun addGuest(model: Model) = guestRepository.addQuote(model)
}