package model

data class Model (var name: String = "no salio", var phone: String = "",
             var email: String = "", var registered: String = ""){
    override fun toString(): String {
        return "$name - $phone - $email"
    }



}
