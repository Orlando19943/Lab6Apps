package model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeGuestDao {
    private val guestList = mutableListOf<Model>()
    private val guest = MutableLiveData<List<Model>>()
    private val role = MutableLiveData<List<Role>>()
    private val roleList = mutableListOf<Role>()

    init {
        guest.value = guestList
        role.value = roleList
    }

    fun addGuest(model: Model) {
        guestList.add(model)
        guest.value = guestList
    }
    fun addRole (role: Role){
        roleList.add (role)
        this.role.value = roleList
    }
    fun getQuotes() = guest as LiveData<List<Model>>
    fun getRole() = role as LiveData<List<Role>>
}