package model

class GuestRepository private constructor(private val quoteDao: FakeGuestDao) {

    fun addQuote(model: Model) {
        quoteDao.addGuest(model)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: GuestRepository? = null

        fun getInstance(guestDao: FakeGuestDao) =
            instance ?: synchronized(this) {
                instance ?: GuestRepository(guestDao).also { instance = it }
            }
    }
}