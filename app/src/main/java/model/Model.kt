package model

data class Model (var name: String = "no salio", var phone: String = "",
             var email: String = "", var role_id: String = "",var registered: String = ""){
    override fun toString(): String {
        return "$name - $phone - $email -$role_id"
    }



}
