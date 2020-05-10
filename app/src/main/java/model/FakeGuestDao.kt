package model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeGuestDao {
    private val guestList = mutableListOf<Model>()
    private val guest = MutableLiveData<List<Model>>()

    init {
        guest.value = guestList
    }

    fun addGuest(model: Model) {
        guestList.add(model)
        guest.value = guestList
    }

    fun getQuotes() = guest as LiveData<List<Model>>
}