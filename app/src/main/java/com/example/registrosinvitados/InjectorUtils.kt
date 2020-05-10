package com.example.registrosinvitados

import model.FakeDatabase
import model.GuestRepository

object InjectorUtils {

    fun provideGuestViewModelFactory(): GuestViewModelFactory {
        val quoteRepository = GuestRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return GuestViewModelFactory(quoteRepository)
    }
}