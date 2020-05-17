package com.example.registrosinvitados.Guest

import androidx.lifecycle.ViewModel
import model.GuestRepository
import model.Model
import model.Role

class GuestViewModel(private val guestRepository: GuestRepository)
    : ViewModel() {

    fun getGuest() = guestRepository.getQuotes()
    fun getRole() = guestRepository.getRole()
    fun addGuest(model: Model) = guestRepository.addQuote(model)
    fun addRole (role: Role) = guestRepository.addRole(role)
}