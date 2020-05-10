package com.example.registrosinvitados

import androidx.lifecycle.ViewModel
import model.GuestRepository
import model.Model

class GuestViewModel(private val guestRepository: GuestRepository)
    : ViewModel() {

    fun getGuest() = guestRepository.getQuotes()

    fun addGuest(model: Model) = guestRepository.addQuote(model)
}