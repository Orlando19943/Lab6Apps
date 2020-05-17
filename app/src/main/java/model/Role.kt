package model

data class Role(var name: String = "", var description: String = "", var order: Int = 0, var rol : Int = 1) {
    override fun toString(): String {
        return "$name - $description - $order "
    }
}