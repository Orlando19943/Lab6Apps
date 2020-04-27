package model

data class Model (var name: String = "Orlando", var phone: String = "57155217",
             var email: String = "orlando.osberto@gmail.com", var registered: String = "No", var i:Int = 1){
    init {
        name = when (i){
            1 -> "Andres"
            2 -> "Yolanda"
            3 -> "Urizar"
            4 -> "Diego"
            5 -> "Ana"
            6 -> "Andrea"
            7 -> "Orlando"
            else -> "Orlando"
        }
        email = when(i){
            1 -> "Andres@hotmail.com"
            2 -> "Yolanda@hotmail.com"
            3 -> "Urizar@gmail.com"
            4 -> "Diego@hotmail.com"
            5 -> "Ana@gmail.com"
            6 -> "Andrea@gmail.com"
            7 -> "Orlando@gmail.com"
            else -> "Orlando@gmail.com"
        }
        phone = when (i){
            1 -> "55863216"
            2 -> "54267132"
            3 -> "59643178"
            4 -> "53142568"
            5 -> "52646925"
            6 -> "51236458"
            7 -> "57856435"
            else -> "57155217"
        }
    }
}
