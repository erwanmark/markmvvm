package net.simplifiedcoding

data class Medical(
    // on below line creating variables.
    var doctorsName: String? = "",
    var doctorsLocation: String? = "",
    var doctorsSpecialisation: String? = "",
    val doctorsContacts: String = "",
    var consoltationCharges: String? = "",
    var regestrationNumber: String? = "",
)

