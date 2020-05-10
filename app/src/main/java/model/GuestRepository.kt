package model

class GuestRepository private constructor(private val quoteDao: FakeGuestDao) {

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun addQuote(model: Model) {
        quoteDao.addQuote(model)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: GuestRepository? = null

        fun getInstance(guestDao: FakeGuestDao) =
            instance ?: synchronized(this) {
                instance ?: GuestRepository(guestDao).also { instance = it }
            }
    }
}