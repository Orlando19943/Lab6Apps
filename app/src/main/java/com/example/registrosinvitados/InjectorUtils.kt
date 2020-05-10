package com.example.registrosinvitados

import model.FakeDatabase
import model.GuestRepository

object InjectorUtils {

    // This will be called from QuotesActivity
    fun provideGuestViewModelFactory(): GuestViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = GuestRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return GuestViewModelFactory(quoteRepository)
    }
}