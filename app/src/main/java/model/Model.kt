package model

data class Model (var name: String = "no salio", var phone: String = "",
             var email: String = "", var registered: String = "", var role_id: Int = 0){
    override fun toString(): String {
        return "$name - $phone - $email -$role_id"
    }



}
