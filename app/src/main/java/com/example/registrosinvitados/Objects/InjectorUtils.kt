package com.example.registrosinvitados.Objects

import com.example.registrosinvitados.Guest.GuestViewModelFactory
import model.FakeDatabase
import model.GuestRepository

object InjectorUtils {

    fun provideGuestViewModelFactory(): GuestViewModelFactory {
        val quoteRepository = GuestRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return GuestViewModelFactory(
            quoteRepository
        )
    }
}