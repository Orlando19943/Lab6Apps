package model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeGuestDao {
    // A fake database table
    private val quoteList = mutableListOf<Model>()
    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val quotes = MutableLiveData<List<Model>>()

    init {
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        quotes.value = quoteList
    }

    fun addQuote(model: Model) {
        quoteList.add(model)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        quotes.value = quoteList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getQuotes() = quotes as LiveData<List<Model>>
}